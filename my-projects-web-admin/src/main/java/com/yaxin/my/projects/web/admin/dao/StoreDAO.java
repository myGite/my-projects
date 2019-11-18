package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 商家的DAO层
 */
@Repository
public interface StoreDAO {
    /**
     * 通过传入商家的id，从而获得商家的信息
     * @param storeid
     * @return
     */
    Store selectByStoreId(@Param("storeid") Integer storeid);

    /**
     * 查询出所有商家的信息
     * Map集合中，第一个key：storeid,   value:storeid所对应的值
     * Map集合中，第一个key：storename,   value:storename所对应的值
     * Map集合中，第一个key：storeadd,   value:storeadd所对应的值
     * Map集合中，第一个key：storedesc,   value:storedesc所对应的值
     * Map集合中，第一个key：delivername,   value:delivername所对应的值
     * Map集合中，第一个key：pics,   value:pics所对应的值
     * Map集合中，第一个key：storetime,   value:storetime所对应的值
     * Map集合中，第一个key：storephone,   value:storephone所对应的值
     * Map集合中，第一个key：beginprice,   value:beginprice所对应的值
     * Map集合中，第一个key：activityids,   value:activityids所对应的值
     * Map集合中，第一个key：monthsale,   value:monthsale所对应的值
     * Map集合中，第一个key：startprice,   value:startprice所对应的值
     * 做到与数据库中查询出的结果集一一对应
     * @return
     */
    List<Map<String, Object>> selectStoreList();
}
