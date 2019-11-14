package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.Car;
import com.yaxin.my.projects.web.admin.dao.CarDAO;
import com.yaxin.my.projects.web.admin.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 购物车Service层的实现类
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDAO carDAO;

    /**
     * 获取该用户购物车中的所有记录
     * @param car
     * @return
     */
    @Override
    public List<Map<String, Object>> findCar(Car car) {
        return carDAO.selectCar(car);
    }

    /**
     * 根据用户id和商品id查询购物车信息
     * @param car
     * @return
     */
    @Override
    public Car findOne(Car car) {
        return carDAO.selectOne(car);
    }

    /**
     * 加入购物车的实现类
     * @param car
     */
    @Override
    public void addCar(Car car) {
        carDAO.insertCar(car);
    }

    /**
     * 修改购物车中商品的信息
     * @param car
     */
    @Override
    public void editCar(Car car) {
        carDAO.updateCar(car);
    }

    /**
     * 删除购物车中某一商品的信息
     * @param car
     */
    @Override
    public void deleteOne(Car car) {
        carDAO.deleteOne(car);
    }
}
