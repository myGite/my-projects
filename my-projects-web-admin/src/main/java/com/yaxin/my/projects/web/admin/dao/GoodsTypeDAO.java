package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsTypeDAO {
    List<GoodsType> selectAll();
}
