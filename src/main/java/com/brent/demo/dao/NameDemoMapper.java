package com.brent.demo.dao;

import com.brent.demo.mode.po.NameDemo;
import com.brent.demo.mode.po.NameDemoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NameDemoMapper {
    long countByExample(NameDemoExample example);

    int deleteByExample(NameDemoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NameDemo record);

    int insertSelective(NameDemo record);

    List<NameDemo> selectByExample(NameDemoExample example);

    NameDemo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NameDemo record, @Param("example") NameDemoExample example);

    int updateByExample(@Param("record") NameDemo record, @Param("example") NameDemoExample example);

    int updateByPrimaryKeySelective(NameDemo record);

    int updateByPrimaryKey(NameDemo record);
}