package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.Store;
import com.yaxin.my.projects.web.admin.dao.StoreDAO;
import com.yaxin.my.projects.web.admin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDAO storeDAO;

    @Override
    public Store findByStoreId(Integer storeid) {
        return storeDAO.selectByStoreId(storeid);
    }

    @Override
    public List<Store> findStoreList() {
        return storeDAO.selectStoreList();
    }
}
