package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsTypeDAO {
    //查询出所有商品类型的数据
    List<GoodsType> selectAll();

    //通过传入商品类型id，获取对应商品类型的信息
    GoodsType selectByGoodsTypeId(Integer goodstypeid);
}
