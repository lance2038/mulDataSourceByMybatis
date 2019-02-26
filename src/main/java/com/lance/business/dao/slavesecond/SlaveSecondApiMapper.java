package com.lance.business.dao.slavesecond;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lance
 */
@Mapper
@Repository
public interface SlaveSecondApiMapper
{

    /**
     * 获取项目
     *
     * @return
     */
    List<Map> getAllItemInfo();
}
