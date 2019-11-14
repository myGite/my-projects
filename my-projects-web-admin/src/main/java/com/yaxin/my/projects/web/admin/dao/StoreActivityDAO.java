package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.StoreActivity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreActivityDAO {
    List<StoreActivity> selectStoreActivityById(@Param("storeActivityList") List<Integer> storeActivityList);
}
