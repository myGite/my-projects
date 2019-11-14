package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.StoreReview;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreReviewDAO {

    /**
     * 根据商家的id，查询出该商家对应的所有评论
     * Map集合中，第一个key：nickname,   value:nickname所对应的值
     * Map集合中，第一个key：avatar,   value:avatar所对应的值
     * Map集合中，第一个key：text,   value:text所对应的值
     * Map集合中，第一个key：rateType,   value:rateType所对应的值
     * Map集合中，第一个key：rateTime,   value:rateTime所对应的值
     * Map集合中，第一个key：score,   value:score所对应的值
     * Map集合中，第一个key：recommend,   value:recommend所对应的值
     * Map集合中，第一个key：storename,   value:storename所对应的值
     * 做到与数据库中查询出的结果集一一对应
     * @param storeid
     * @return
     */
    List<Map<String,Object>> selectStoreReview(int storeid);

    /**
     *
     * @param storeReview
     */
    void insertStoerReview(StoreReview storeReview);
}
