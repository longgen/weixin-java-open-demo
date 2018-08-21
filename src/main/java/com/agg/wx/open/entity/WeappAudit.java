package com.agg.wx.open.entity;

import java.util.Date;

public class WeappAudit {
    private Long id;

    private String appId;

    private Long auditid;

    private Integer status;

    private Long templateid;

    private String cid;

    private String tag;

    private String title;

    private String reason;

    private String devVersion;

    private String devDesc;

    private Date devTime;

    private String auditVersion;

    private String auditDesc;

    private Date auditTime;

    private String prodVersion;

    private String prodDesc;

    private Date prodTime;

    private String lastCodeJson;

    private String remark;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Long getAuditid() {
        return auditid;
    }

    public void setAuditid(Long auditid) {
        this.auditid = auditid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Long templateid) {
        this.templateid = templateid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDevVersion() {
        return devVersion;
    }

    public void setDevVersion(String devVersion) {
        this.devVersion = devVersion;
    }

    public String getDevDesc() {
        return devDesc;
    }

    public void setDevDesc(String devDesc) {
        this.devDesc = devDesc;
    }

    public Date getDevTime() {
        return devTime;
    }

    public void setDevTime(Date devTime) {
        this.devTime = devTime;
    }

    public String getAuditVersion() {
        return auditVersion;
    }

    public void setAuditVersion(String auditVersion) {
        this.auditVersion = auditVersion;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getProdVersion() {
        return prodVersion;
    }

    public void setProdVersion(String prodVersion) {
        this.prodVersion = prodVersion;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public Date getProdTime() {
        return prodTime;
    }

    public void setProdTime(Date prodTime) {
        this.prodTime = prodTime;
    }

    public String getLastCodeJson() {
        return lastCodeJson;
    }

    public void setLastCodeJson(String lastCodeJson) {
        this.lastCodeJson = lastCodeJson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}