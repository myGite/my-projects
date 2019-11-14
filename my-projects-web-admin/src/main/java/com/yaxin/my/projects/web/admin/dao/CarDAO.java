package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 购物车的DAO层
 */
@Repository
public interface CarDAO {
    /**
     * 查询该用户的购物车的所有商品
     * Map集合中，第一个key：goodsname,   value:goodsname所对应的值
     * Map集合中，第一个key：goodsprice,   value:goodsprice所对应的值
     * Map集合中，第一个key：goodsnum,   value:goodsnum所对应的值
     * Map集合中，第一个key：goodssum,   value:goodssum所对应的值
     * 做到与数据库中查询出的结果集一一对应
     * @param car
     * @return
     */
    List<Map<String,Object>> selectCar(Car car);

    /**
     * 根据出入的商品id和用户id查询查询这一商品的情况
     * @param car
     * @return
     */
    Car selectOne(Car car);

    /**
     * 加入购物车（当该用户购物车中一开始就没有该商品时）
     * @param car
     */
    void insertCar(Car car);

    /**
     * 修改该用户下购物车的信息（商品的数量和商品总价）
     * @param car
     */
    void updateCar(Car car);

    /**
     * 清空该用户下对应商品的记录
     * @param car
     */
    void deleteOne(Car car);

    /**
     * 清空该用户的购物车
     * @param userid
     */
    void deleteByUserid(Integer userid);
}
