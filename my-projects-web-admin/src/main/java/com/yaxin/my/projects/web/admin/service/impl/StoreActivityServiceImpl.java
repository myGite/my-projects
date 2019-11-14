package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.StoreActivity;
import com.yaxin.my.projects.web.admin.dao.StoreActivityDAO;
import com.yaxin.my.projects.web.admin.service.StoreActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreActivityServiceImpl implements StoreActivityService {

    @Autowired
    private StoreActivityDAO storeActivityDAO;

    @Override
    public List<StoreActivity> findByStoreActivityId(List<Integer> storeActivityList) {
        return storeActivityDAO.selectStoreActivityById(storeActivityList);
    }
}
