package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.GoodsType;
import com.yaxin.my.projects.web.admin.dao.GoodsTypeDAO;
import com.yaxin.my.projects.web.admin.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    private static final String GOODS_TYPE="goodsType";

    @Autowired
    private GoodsTypeDAO goodsTypeDAO;

    @Override
    public List<GoodsType> findAll() {
        return goodsTypeDAO.selectAll();
    }
}
