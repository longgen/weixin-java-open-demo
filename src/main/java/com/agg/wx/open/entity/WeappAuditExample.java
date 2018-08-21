package com.agg.wx.open.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeappAuditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeappAuditExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAuditidIsNull() {
            addCriterion("auditid is null");
            return (Criteria) this;
        }

        public Criteria andAuditidIsNotNull() {
            addCriterion("auditid is not null");
            return (Criteria) this;
        }

        public Criteria andAuditidEqualTo(Long value) {
            addCriterion("auditid =", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotEqualTo(Long value) {
            addCriterion("auditid <>", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidGreaterThan(Long value) {
            addCriterion("auditid >", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidGreaterThanOrEqualTo(Long value) {
            addCriterion("auditid >=", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidLessThan(Long value) {
            addCriterion("auditid <", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidLessThanOrEqualTo(Long value) {
            addCriterion("auditid <=", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidIn(List<Long> values) {
            addCriterion("auditid in", values, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotIn(List<Long> values) {
            addCriterion("auditid not in", values, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidBetween(Long value1, Long value2) {
            addCriterion("auditid between", value1, value2, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotBetween(Long value1, Long value2) {
            addCriterion("auditid not between", value1, value2, "auditid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTemplateidIsNull() {
            addCriterion("templateId is null");
            return (Criteria) this;
        }

        public Criteria andTemplateidIsNotNull() {
            addCriterion("templateId is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateidEqualTo(Long value) {
            addCriterion("templateId =", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidNotEqualTo(Long value) {
            addCriterion("templateId <>", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidGreaterThan(Long value) {
            addCriterion("templateId >", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidGreaterThanOrEqualTo(Long value) {
            addCriterion("templateId >=", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidLessThan(Long value) {
            addCriterion("templateId <", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidLessThanOrEqualTo(Long value) {
            addCriterion("templateId <=", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidIn(List<Long> values) {
            addCriterion("templateId in", values, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidNotIn(List<Long> values) {
            addCriterion("templateId not in", values, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidBetween(Long value1, Long value2) {
            addCriterion("templateId between", value1, value2, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidNotBetween(Long value1, Long value2) {
            addCriterion("templateId not between", value1, value2, "templateid");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("cid like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("cid not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andDevVersionIsNull() {
            addCriterion("dev_version is null");
            return (Criteria) this;
        }

        public Criteria andDevVersionIsNotNull() {
            addCriterion("dev_version is not null");
            return (Criteria) this;
        }

        public Criteria andDevVersionEqualTo(String value) {
            addCriterion("dev_version =", value, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionNotEqualTo(String value) {
            addCriterion("dev_version <>", value, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionGreaterThan(String value) {
            addCriterion("dev_version >", value, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionGreaterThanOrEqualTo(String value) {
            addCriterion("dev_version >=", value, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionLessThan(String value) {
            addCriterion("dev_version <", value, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionLessThanOrEqualTo(String value) {
            addCriterion("dev_version <=", value, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionLike(String value) {
            addCriterion("dev_version like", value, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionNotLike(String value) {
            addCriterion("dev_version not like", value, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionIn(List<String> values) {
            addCriterion("dev_version in", values, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionNotIn(List<String> values) {
            addCriterion("dev_version not in", values, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionBetween(String value1, String value2) {
            addCriterion("dev_version between", value1, value2, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevVersionNotBetween(String value1, String value2) {
            addCriterion("dev_version not between", value1, value2, "devVersion");
            return (Criteria) this;
        }

        public Criteria andDevDescIsNull() {
            addCriterion("dev_desc is null");
            return (Criteria) this;
        }

        public Criteria andDevDescIsNotNull() {
            addCriterion("dev_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDevDescEqualTo(String value) {
            addCriterion("dev_desc =", value, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescNotEqualTo(String value) {
            addCriterion("dev_desc <>", value, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescGreaterThan(String value) {
            addCriterion("dev_desc >", value, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescGreaterThanOrEqualTo(String value) {
            addCriterion("dev_desc >=", value, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescLessThan(String value) {
            addCriterion("dev_desc <", value, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescLessThanOrEqualTo(String value) {
            addCriterion("dev_desc <=", value, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescLike(String value) {
            addCriterion("dev_desc like", value, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescNotLike(String value) {
            addCriterion("dev_desc not like", value, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescIn(List<String> values) {
            addCriterion("dev_desc in", values, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescNotIn(List<String> values) {
            addCriterion("dev_desc not in", values, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescBetween(String value1, String value2) {
            addCriterion("dev_desc between", value1, value2, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevDescNotBetween(String value1, String value2) {
            addCriterion("dev_desc not between", value1, value2, "devDesc");
            return (Criteria) this;
        }

        public Criteria andDevTimeIsNull() {
            addCriterion("dev_time is null");
            return (Criteria) this;
        }

        public Criteria andDevTimeIsNotNull() {
            addCriterion("dev_time is not null");
            return (Criteria) this;
        }

        public Criteria andDevTimeEqualTo(Date value) {
            addCriterion("dev_time =", value, "devTime");
            return (Criteria) this;
        }

        public Criteria andDevTimeNotEqualTo(Date value) {
            addCriterion("dev_time <>", value, "devTime");
            return (Criteria) this;
        }

        public Criteria andDevTimeGreaterThan(Date value) {
            addCriterion("dev_time >", value, "devTime");
            return (Criteria) this;
        }

        public Criteria andDevTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dev_time >=", value, "devTime");
            return (Criteria) this;
        }

        public Criteria andDevTimeLessThan(Date value) {
            addCriterion("dev_time <", value, "devTime");
            return (Criteria) this;
        }

        public Criteria andDevTimeLessThanOrEqualTo(Date value) {
            addCriterion("dev_time <=", value, "devTime");
            return (Criteria) this;
        }

        public Criteria andDevTimeIn(List<Date> values) {
            addCriterion("dev_time in", values, "devTime");
            return (Criteria) this;
        }

        public Criteria andDevTimeNotIn(List<Date> values) {
            addCriterion("dev_time not in", values, "devTime");
            return (Criteria) this;
        }

        public Criteria andDevTimeBetween(Date value1, Date value2) {
            addCriterion("dev_time between", value1, value2, "devTime");
            return (Criteria) this;
        }

        public Criteria andDevTimeNotBetween(Date value1, Date value2) {
            addCriterion("dev_time not between", value1, value2, "devTime");
            return (Criteria) this;
        }

        public Criteria andAuditVersionIsNull() {
            addCriterion("audit_version is null");
            return (Criteria) this;
        }

        public Criteria andAuditVersionIsNotNull() {
            addCriterion("audit_version is not null");
            return (Criteria) this;
        }

        public Criteria andAuditVersionEqualTo(String value) {
            addCriterion("audit_version =", value, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionNotEqualTo(String value) {
            addCriterion("audit_version <>", value, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionGreaterThan(String value) {
            addCriterion("audit_version >", value, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionGreaterThanOrEqualTo(String value) {
            addCriterion("audit_version >=", value, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionLessThan(String value) {
            addCriterion("audit_version <", value, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionLessThanOrEqualTo(String value) {
            addCriterion("audit_version <=", value, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionLike(String value) {
            addCriterion("audit_version like", value, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionNotLike(String value) {
            addCriterion("audit_version not like", value, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionIn(List<String> values) {
            addCriterion("audit_version in", values, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionNotIn(List<String> values) {
            addCriterion("audit_version not in", values, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionBetween(String value1, String value2) {
            addCriterion("audit_version between", value1, value2, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditVersionNotBetween(String value1, String value2) {
            addCriterion("audit_version not between", value1, value2, "auditVersion");
            return (Criteria) this;
        }

        public Criteria andAuditDescIsNull() {
            addCriterion("audit_desc is null");
            return (Criteria) this;
        }

        public Criteria andAuditDescIsNotNull() {
            addCriterion("audit_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAuditDescEqualTo(String value) {
            addCriterion("audit_desc =", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescNotEqualTo(String value) {
            addCriterion("audit_desc <>", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescGreaterThan(String value) {
            addCriterion("audit_desc >", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescGreaterThanOrEqualTo(String value) {
            addCriterion("audit_desc >=", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescLessThan(String value) {
            addCriterion("audit_desc <", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescLessThanOrEqualTo(String value) {
            addCriterion("audit_desc <=", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescLike(String value) {
            addCriterion("audit_desc like", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescNotLike(String value) {
            addCriterion("audit_desc not like", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescIn(List<String> values) {
            addCriterion("audit_desc in", values, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescNotIn(List<String> values) {
            addCriterion("audit_desc not in", values, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescBetween(String value1, String value2) {
            addCriterion("audit_desc between", value1, value2, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescNotBetween(String value1, String value2) {
            addCriterion("audit_desc not between", value1, value2, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andProdVersionIsNull() {
            addCriterion("prod_version is null");
            return (Criteria) this;
        }

        public Criteria andProdVersionIsNotNull() {
            addCriterion("prod_version is not null");
            return (Criteria) this;
        }

        public Criteria andProdVersionEqualTo(String value) {
            addCriterion("prod_version =", value, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionNotEqualTo(String value) {
            addCriterion("prod_version <>", value, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionGreaterThan(String value) {
            addCriterion("prod_version >", value, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionGreaterThanOrEqualTo(String value) {
            addCriterion("prod_version >=", value, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionLessThan(String value) {
            addCriterion("prod_version <", value, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionLessThanOrEqualTo(String value) {
            addCriterion("prod_version <=", value, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionLike(String value) {
            addCriterion("prod_version like", value, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionNotLike(String value) {
            addCriterion("prod_version not like", value, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionIn(List<String> values) {
            addCriterion("prod_version in", values, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionNotIn(List<String> values) {
            addCriterion("prod_version not in", values, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionBetween(String value1, String value2) {
            addCriterion("prod_version between", value1, value2, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdVersionNotBetween(String value1, String value2) {
            addCriterion("prod_version not between", value1, value2, "prodVersion");
            return (Criteria) this;
        }

        public Criteria andProdDescIsNull() {
            addCriterion("prod_desc is null");
            return (Criteria) this;
        }

        public Criteria andProdDescIsNotNull() {
            addCriterion("prod_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProdDescEqualTo(String value) {
            addCriterion("prod_desc =", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescNotEqualTo(String value) {
            addCriterion("prod_desc <>", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescGreaterThan(String value) {
            addCriterion("prod_desc >", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescGreaterThanOrEqualTo(String value) {
            addCriterion("prod_desc >=", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescLessThan(String value) {
            addCriterion("prod_desc <", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescLessThanOrEqualTo(String value) {
            addCriterion("prod_desc <=", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescLike(String value) {
            addCriterion("prod_desc like", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescNotLike(String value) {
            addCriterion("prod_desc not like", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescIn(List<String> values) {
            addCriterion("prod_desc in", values, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescNotIn(List<String> values) {
            addCriterion("prod_desc not in", values, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescBetween(String value1, String value2) {
            addCriterion("prod_desc between", value1, value2, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescNotBetween(String value1, String value2) {
            addCriterion("prod_desc not between", value1, value2, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdTimeIsNull() {
            addCriterion("prod_time is null");
            return (Criteria) this;
        }

        public Criteria andProdTimeIsNotNull() {
            addCriterion("prod_time is not null");
            return (Criteria) this;
        }

        public Criteria andProdTimeEqualTo(Date value) {
            addCriterion("prod_time =", value, "prodTime");
            return (Criteria) this;
        }

        public Criteria andProdTimeNotEqualTo(Date value) {
            addCriterion("prod_time <>", value, "prodTime");
            return (Criteria) this;
        }

        public Criteria andProdTimeGreaterThan(Date value) {
            addCriterion("prod_time >", value, "prodTime");
            return (Criteria) this;
        }

        public Criteria andProdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("prod_time >=", value, "prodTime");
            return (Criteria) this;
        }

        public Criteria andProdTimeLessThan(Date value) {
            addCriterion("prod_time <", value, "prodTime");
            return (Criteria) this;
        }

        public Criteria andProdTimeLessThanOrEqualTo(Date value) {
            addCriterion("prod_time <=", value, "prodTime");
            return (Criteria) this;
        }

        public Criteria andProdTimeIn(List<Date> values) {
            addCriterion("prod_time in", values, "prodTime");
            return (Criteria) this;
        }

        public Criteria andProdTimeNotIn(List<Date> values) {
            addCriterion("prod_time not in", values, "prodTime");
            return (Criteria) this;
        }

        public Criteria andProdTimeBetween(Date value1, Date value2) {
            addCriterion("prod_time between", value1, value2, "prodTime");
            return (Criteria) this;
        }

        public Criteria andProdTimeNotBetween(Date value1, Date value2) {
            addCriterion("prod_time not between", value1, value2, "prodTime");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonIsNull() {
            addCriterion("last_code_json is null");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonIsNotNull() {
            addCriterion("last_code_json is not null");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonEqualTo(String value) {
            addCriterion("last_code_json =", value, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonNotEqualTo(String value) {
            addCriterion("last_code_json <>", value, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonGreaterThan(String value) {
            addCriterion("last_code_json >", value, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonGreaterThanOrEqualTo(String value) {
            addCriterion("last_code_json >=", value, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonLessThan(String value) {
            addCriterion("last_code_json <", value, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonLessThanOrEqualTo(String value) {
            addCriterion("last_code_json <=", value, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonLike(String value) {
            addCriterion("last_code_json like", value, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonNotLike(String value) {
            addCriterion("last_code_json not like", value, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonIn(List<String> values) {
            addCriterion("last_code_json in", values, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonNotIn(List<String> values) {
            addCriterion("last_code_json not in", values, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonBetween(String value1, String value2) {
            addCriterion("last_code_json between", value1, value2, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andLastCodeJsonNotBetween(String value1, String value2) {
            addCriterion("last_code_json not between", value1, value2, "lastCodeJson");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}