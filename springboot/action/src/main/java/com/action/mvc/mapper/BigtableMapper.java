package com.action.mvc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.action.mvc.domain.entity.Bigtable;
import com.action.mvc.domain.entity.BigtableExample;

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