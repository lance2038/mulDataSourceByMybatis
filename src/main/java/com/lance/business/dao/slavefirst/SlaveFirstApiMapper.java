package com.lance.business.dao.slavefirst;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lance
 */
@Mapper
@Repository
public interface SlaveFirstApiMapper
{

    /**
     * 获取项目
     *
     * @return
     */
    List<Map> getAllItemInfo();
}
