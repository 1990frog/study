package com.action.mvc.mapper;

import com.action.mvc.domain.entity.Bigtable;
import com.action.mvc.domain.entity.BigtableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BigtableMapper {
    long countByExample(BigtableExample example);

    int deleteByExample(BigtableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bigtable record);

    int insertSelective(Bigtable record);

    List<Bigtable> selectByExample(BigtableExample example);

    Bigtable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bigtable record, @Param("example") BigtableExample example);

    int updateByExample(@Param("record") Bigtable record, @Param("example") BigtableExample example);

    int updateByPrimaryKeySelective(Bigtable record);

    int updateByPrimaryKey(Bigtable record);
}