package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    //获取商品类型中的所有信息
    List<GoodsType> findAll();

    //通过传入的商品类型id，获取对应商品类型的信息
    GoodsType findByGoodsTypeId(Integer goodstypeid);

}
