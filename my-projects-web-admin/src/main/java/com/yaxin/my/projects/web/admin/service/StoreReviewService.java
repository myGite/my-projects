package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.StoreReview;

import java.util.List;
import java.util.Map;

public interface StoreReviewService {
    /**
     * 根据商家的id，获取商家的所有的评论
     * @param storeid
     * @return
     */
    List<Map<String,Object>> findStoreReview(int storeid);

    /**
     * 添加商家的评论
     * @param storeReview
     */
    void addStoreReview(StoreReview storeReview);
}
