package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.Goods;
import com.yaxin.my.projects.web.admin.dao.GoodsDAO;
import com.yaxin.my.projects.web.admin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
