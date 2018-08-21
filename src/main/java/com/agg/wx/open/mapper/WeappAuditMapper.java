package com.agg.wx.open.mapper;

import com.agg.wx.open.entity.WeappAudit;
import com.agg.wx.open.entity.WeappAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeappAuditMapper {
    long countByExample(WeappAuditExample example);

    int deleteByExample(WeappAuditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeappAudit record);

    int insertSelective(WeappAudit record);

    List<WeappAudit> selectByExample(WeappAuditExample example);

    WeappAudit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeappAudit record, @Param("example") WeappAuditExample example);

    int updateByExample(@Param("record") WeappAudit record, @Param("example") WeappAuditExample example);

    int updateByPrimaryKeySelective(WeappAudit record);

    int updateByPrimaryKey(WeappAudit record);
}