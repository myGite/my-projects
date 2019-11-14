package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.StoreActivity;

import java.util.List;

public interface StoreActivityService {
    List<StoreActivity> findByStoreActivityId(List<Integer> storeActivityList);
}
