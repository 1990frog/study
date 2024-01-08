package com.action.mvc.mapper;

import com.action.mvc.domain.entity.Canal;
import com.action.mvc.domain.entity.CanalExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CanalMapper {
    long countByExample(CanalExample example);

    int deleteByExample(CanalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Canal record);

    int insertSelective(Canal record);

    List<Canal> selectByExample(CanalExample example);

    Canal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Canal record, @Param("example") CanalExample example);

    int updateByExample(@Param("record") Canal record, @Param("example") CanalExample example);

    int updateByPrimaryKeySelective(Canal record);

    int updateByPrimaryKey(Canal record);

    List<Map<String,Object>> query(@Param("id")Integer id);
}