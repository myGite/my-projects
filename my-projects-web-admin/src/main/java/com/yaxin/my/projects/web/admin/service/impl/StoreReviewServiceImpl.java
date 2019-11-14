package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.StoreReview;
import com.yaxin.my.projects.web.admin.dao.StoreReviewDAO;
import com.yaxin.my.projects.web.admin.service.StoreReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreReviewServiceImpl implements StoreReviewService {

    @Autowired
    private StoreReviewDAO storeReviewDAO;

    /**
     * 实现根据商家的id，获取该商家的所有评论的方法
     * @return
     */
    @Override
    public List<Map<String,Object>> findStoreReview(int storeid) {
        return storeReviewDAO.selectStoreReview(storeid);
    }

    /**
     * 实现添加商家的评论
     * @param storeReview
     */
    @Override
    public void addStoreReview(StoreReview storeReview) {
        storeReviewDAO.insertStoerReview(storeReview);
    }
}
