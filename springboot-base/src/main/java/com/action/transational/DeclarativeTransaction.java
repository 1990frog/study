package com.action.transational;

import com.action.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 * 实现声明式事务
 */
@Slf4j
@Controller
public class DeclarativeTransaction {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 注解参数全默认
     * 默认RuntimeException触发事务回滚
     * 默认Required为事务传递等级
     */
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (1, 1, 'AAA')");
    }

    /**
     * 自定义异常触发事务
     * @throws RollbackException
     */
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (2, 2, 'BBB')");
        throw new RollbackException();
    }


    @Transactional
    public Result execute(){
        try{
            log.info("dbsize is {}",getCount());
            jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (3, 3, 'CCC')");
            throw new RuntimeException();
        }catch (Exception e){
            throw e;
        }finally {
            // 这里多打出一条数据，是因为finally发生在抛出异常之前，而抛出异常才会触发事务
            log.info("dbsize is {}",getCount());
        }
    }

    private long getCount() {
        return (long) jdbcTemplate.queryForList("SELECT COUNT(*) AS CNT FROM transaction")
                .get(0).get("CNT");
    }


}
