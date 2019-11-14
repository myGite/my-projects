package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.Car;

import java.util.List;
import java.util.Map;

/**
 * 购物车的Service层接口
 */
public interface CarService {
    /**
     * 查询当前用户购物车里面的所有数据
     * @param car
     * @return
     */
    List<Map<String,Object>> findCar(Car car);

    /**
     * 根据传入封装的car对象（userid,goodsid），获取购物车中商品的情况
     * @param car
     * @return
     */
    Car findOne(Car car);

    /**
     * 加入购物车（购物车中一开始没有该商品的情况）
     * @param car
     */
    void addCar(Car car);

    /**
     * 修改购物车信息（主要是修改购物车中商品的数量和对应的总价）
     * @param car
     */
    void editCar(Car car);

    /**
     * 删除购物车中一种商品的信息
     * @param car
     */
    void deleteOne(Car car);

}
