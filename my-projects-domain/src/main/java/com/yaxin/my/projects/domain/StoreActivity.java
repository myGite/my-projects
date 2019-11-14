package com.yaxin.my.projects.domain;

import java.io.Serializable;

/**
 * 商家活动
 */
public class StoreActivity implements Serializable {
    //活动id
    private Integer activityid;
    //活动内容
    private String content;
    //优惠类型id
    private String activitytypeid;

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getActivitytypeid() {
        return activitytypeid;
    }

    public void setActivitytypeid(String activitytypeid) {
        this.activitytypeid = activitytypeid;
    }

    @Override
    public String toString() {
        return "StoreActivity{" +
                "activityid=" + activityid +
                ", content='" + content + '\'' +
                ", activitytypeid='" + activitytypeid + '\'' +
                '}';
    }
}
