package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.Store;

import java.util.List;

/**
 * 商家Service层
 */
public interface StoreService {
    /**
     * 通过传入商家的id，从而获取该商家的信息
     * @param storeid
     * @return
     */
    Store findByStoreId(Integer storeid);

    /**
     * 获取所有商家的信息
     * @return
     */
    List<Store> findStoreList();
}
