package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsDAO {
    //查询关于某类型所有的商品
    //List<Goods> selectByTypeId(@Param("goodstypeids") String goodstypeids);
    List<Goods> selectByTypeId(@Param("goodsMap") Map<String,Object> goodsMap);

    /**
     * 根据商品传来的字段，查询出该商品
     * @param goods
     * @return
     */
    Goods selectByColumns(Goods goods);

    /**
     * 查询所有的商品
     * @return
     */
    List<Goods> selectAll();

    /**
     * 根据传入一个商家的id，从而获取该商家的所有商品
     * @param storeid
     * @return
     */
    List<Goods> selectByStoreid(Integer storeid);

    /**
     * 根据传入的商家id和商品类型的id，查询出所有商品
     *
     * 约定：传入的第一个key---value是商家的id
     *       传入的第二个key---value是商品类型的id
     * @param map
     * @return
     */
    List<Goods> selectByTwoid(Map<String,Integer> map);
}
