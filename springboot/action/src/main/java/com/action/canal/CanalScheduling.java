package com.action.canal;

import com.action.mvc.mapper.CanalMapper;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CanalScheduling {

    @Autowired
    private CanalMapper canalMapper;

    @Resource
    private CanalConnector canalConnector;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 定时消费消息
     */
    @Scheduled(fixedDelay = 100)
    public void task() {
        long batchId = -1;
        try{
            // 一次拉取多少消息
            int batchSize = 1000;
            // 从canal消费消息
            Message message = canalConnector.getWithoutAck(batchSize);
            // 这n条数据的批次id
            batchId = message.getId();
            List<CanalEntry.Entry> entries = message.getEntries();
            // 存在变更信息判断
            if(batchId != -1 && entries.size() > 0){
                entries.forEach(entry -> {
                    if(entry.getEntryType() == CanalEntry.EntryType.ROWDATA){
                        //解析处理
                        publishCanalEvent(entry);
                    }
                });
            }
            // 确认消费成功
            canalConnector.ack(batchId);
        }catch(Exception e){
            e.printStackTrace();
            // 没有消费成功，回滚消息
            canalConnector.rollback(batchId);
        }

    }

    /**
     * 解析处理函数
     */
    private void publishCanalEvent(CanalEntry.Entry entry){
        // 操作类型：INSERT,UPDATER,DELETE
        CanalEntry.EventType eventType = entry.getHeader().getEventType();
        // mysql的schema
        String database = entry.getHeader().getSchemaName();
        // mysql的table
        String table = entry.getHeader().getTableName();
        // 变化的数据
        CanalEntry.RowChange change = null;
        try {
            change = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return;
        }

        change.getRowDatasList().forEach(rowData -> {
            // 获取批量变化数据的list
            List<CanalEntry.Column> columns = rowData.getAfterColumnsList();
            String primaryKey = "id";
            CanalEntry.Column idColumn = columns.stream().filter(column -> column.getIsKey()
                    && primaryKey.equals(column.getName())).findFirst().orElse(null);

            Map<String, Object> dataMap = parseColumnsToMap(columns);
            try{
                indexES(dataMap,database,table);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    /**
     * 将canal的columns转化成map函数
     */
    Map<String, Object> parseColumnsToMap(List<CanalEntry.Column> columns){
        Map<String, Object> jsonMap = new HashMap<>();
        columns.forEach(column -> {
            if(column == null){
                return;
            }
            jsonMap.put(column.getName(),column.getValue());
        });
        return jsonMap;
    }


    private void indexES(Map<String, Object> dataMap, String database, String table) throws IOException {
        // 目前只处理test库的消息
        if(!StringUtils.equals("test",database)){
            return;
        }
        List<Map<String, Object>> result = new ArrayList<>();
//        if(StringUtils.equals("seller",table)){
//            result = shopModelMapper.buildESQuery(new Integer((String)dataMap.get("id")),null,null);
//        }else if(StringUtils.equals("category",table)){
//            result = shopModelMapper.buildESQuery(null,new Integer((String)dataMap.get("id")),null);
//        }else if(StringUtils.equals("shop",table)){
//            result = shopModelMapper.buildESQuery(null,null,new Integer((String)dataMap.get("id")));
//        }else{
//            return;
//        }

        if(StringUtils.equals("canal",table)){
            result = canalMapper.query(new Integer((String)dataMap.get("id")));
        }

        // 更新es索引
        for(Map<String, Object> map : result){
            IndexRequest indexRequest = new IndexRequest("canal");
            indexRequest.id(String.valueOf(map.get("id")));
            indexRequest.source(map);
            restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        }


    }

}
