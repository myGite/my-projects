package com.yaxin.my.projects.domain;

import java.io.Serializable;

/**
 * 派送方式
 */
public class Deliver implements Serializable {
    //派送方式id
    private Integer deliverid;
    //派送方式名称
    private String delivername;

    public Integer getDeliverid() {
        return deliverid;
    }

    public void setDeliverid(Integer deliverid) {
        this.deliverid = deliverid;
    }

    public String getDelivername() {
        return delivername;
    }

    public void setDelivername(String delivername) {
        this.delivername = delivername;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                "deliverid=" + deliverid +
                ", delivername='" + delivername + '\'' +
                '}';
    }
}
