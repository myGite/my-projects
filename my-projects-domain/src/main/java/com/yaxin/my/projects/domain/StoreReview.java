package com.yaxin.my.projects.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家评论
 */
public class StoreReview implements Serializable {
    //商家id
    private Integer storeid;
    //评论内容
    private String text;
    //评论类型
    private Integer rateType;
    //用户id
    private Integer userid;
    //评论日期
    private Date rateTime;
    //评论分数
    private Double score;
    //相关推荐
    private String recommend;

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRateType() {
        return rateType;
    }

    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getRateTime() {
        return rateTime;
    }

    public void setRateTime(Date rateTime) {
        this.rateTime = rateTime;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "StoreReview{" +
                "storeid=" + storeid +
                ", text='" + text + '\'' +
                ", rateType=" + rateType +
                ", userid='" + userid + '\'' +
                ", rateTime=" + rateTime +
                ", score=" + score +
                ", recommend='" + recommend + '\'' +
                '}';
    }
}
