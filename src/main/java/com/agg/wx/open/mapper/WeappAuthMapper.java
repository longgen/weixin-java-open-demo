package com.agg.wx.open.mapper;

import com.agg.wx.open.entity.WeappAuth;
import com.agg.wx.open.entity.WeappAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeappAuthMapper {
    long countByExample(WeappAuthExample example);

    int deleteByExample(WeappAuthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeappAuth record);

    int insertSelective(WeappAuth record);

    List<WeappAuth> selectByExample(WeappAuthExample example);

    WeappAuth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeappAuth record, @Param("example") WeappAuthExample example);

    int updateByExample(@Param("record") WeappAuth record, @Param("example") WeappAuthExample example);

    int updateByPrimaryKeySelective(WeappAuth record);

    int updateByPrimaryKey(WeappAuth record);
}