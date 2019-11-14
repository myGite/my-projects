package com.yaxin.my.projects.domain;

import java.io.Serializable;

/**
 * 商品所属的类型
 */
public class GoodsType implements Serializable {
    //商品所属类型id
    private Integer goodstypeid;
    //商品所属类型的名称
    private String goodstypename;

    public Integer getGoodstypeid() {
        return goodstypeid;
    }

    public void setGoodstypeid(Integer goodstypeid) {
        this.goodstypeid = goodstypeid;
    }

    public String getGoodstypename() {
        return goodstypename;
    }

    public void setGoodstypename(String goodstypename) {
        this.goodstypename = goodstypename;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "goodstypeid=" + goodstypeid +
                ", goodstypename='" + goodstypename + '\'' +
                '}';
    }
}
