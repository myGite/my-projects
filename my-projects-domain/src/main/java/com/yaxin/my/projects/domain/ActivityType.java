package com.yaxin.my.projects.domain;

import java.io.Serializable;

/**
 * 活动类型
 */
public class ActivityType implements Serializable {
    //活动类型id
    private Integer activitytypeid;
    //活动类型名称
    private String activitytypename;

    public Integer getActivitytypeid() {
        return activitytypeid;
    }

    public void setActivitytypeid(Integer activitytypeid) {
        this.activitytypeid = activitytypeid;
    }

    public String getActivitytypename() {
        return activitytypename;
    }

    public void setActivitytypename(String activitytypename) {
        this.activitytypename = activitytypename;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
                "activitytypeid=" + activitytypeid +
                ", activitytypename='" + activitytypename + '\'' +
                '}';
    }
}
