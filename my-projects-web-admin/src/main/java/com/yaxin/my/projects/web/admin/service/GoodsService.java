package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    /**
     * 查询出所有商品
     * @param goodsMap
     * @return
     */
    //List<Goods> findByTypeId(String goodstypeids);
    List<Goods> findByTypeId(Map<String,Object> goodsMap);

    /**
     * 根据商品传入的字段，获取商品的信息
     */
    Goods findByColumns(Goods goods);

    /**
     * 获取所有的商品
     * @return
     */
    List<Goods> findAll();

    /**
     * 根据商家的id，获取商家的所有商品
     */
    List<Goods> findByStoreid(Integer storeid);

    /**
     * 根据商家的id 和 商品类型的id 获取所有的商品
     * @param storeid
     * @param goodstypeid
     * @return
     */
    List<Goods> findByTowid(Integer storeid, Integer goodstypeid);

}
