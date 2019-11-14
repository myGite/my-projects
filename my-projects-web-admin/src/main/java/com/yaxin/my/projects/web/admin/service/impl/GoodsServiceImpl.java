package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.Goods;
import com.yaxin.my.projects.web.admin.dao.GoodsDAO;
import com.yaxin.my.projects.web.admin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;

    /*@Override
    public List<Goods> findByTypeId(String goodstypeids) {
        return goodsDAO.selectByTypeId(goodstypeids);
    }*/

    @Override
    public List<Goods> findByTypeId(Map<String,Object> goodsMap) {
        return goodsDAO.selectByTypeId(goodsMap);
    }

    @Override
    public Goods findByColumns(Goods goods) {
        return goodsDAO.selectByColumns(goods);
    }

    /**
     * 获取所有商品的实现类
     * @return
     */
    @Override
    public List<Goods> findAll() {
        return goodsDAO.selectAll();
    }

    /**
     * 根据商家的id获取商家的所有商品信息
     * @param storeid
     * @return
     */
    @Override
    public List<Goods> findByStoreid(Integer storeid) {
        return null;
    }

    /**
     * 根据商家的id 和 商品类型的id 获取所有的商品的接口的实现类
     * @param storeid
     * @param goodstypeid
     * @return
     */
    @Override
    public List<Goods> findByTowid(Integer storeid, Integer goodstypeid) {
        Map<String,Integer> map = new HashMap<>();
        map.put("storeid",storeid);
        map.put("goodstypeid",goodstypeid);
        return goodsDAO.selectByTwoid(map);
    }
}
