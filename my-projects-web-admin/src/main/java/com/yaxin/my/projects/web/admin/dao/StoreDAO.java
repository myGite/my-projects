package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<Store> selectStoreList();
}
