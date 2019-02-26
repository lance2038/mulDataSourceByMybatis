package com.lance.business.dao.master;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lance
 */
@Mapper
@Repository
public interface ApiMapper
{

    /**
     * 获取项目
     *
     * @return
     */
    List<Map> getAllItemInfo();
}
