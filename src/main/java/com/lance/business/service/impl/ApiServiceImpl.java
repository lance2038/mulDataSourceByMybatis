package com.lance.business.service.impl;

import com.lance.business.dao.master.ApiMapper;
import com.lance.business.dao.slavefirst.SlaveFirstApiMapper;
import com.lance.business.dao.slavesecond.SlaveSecondApiMapper;
import com.lance.business.service.ApiService;
import com.lance.common.base.model.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>业务处理service接口实现类
 *
 * @author lance
 * @since 2018-09-25
 **/
@Slf4j
@Service
public class ApiServiceImpl implements ApiService
{
    @Autowired
    private ApiMapper apiMapper;
    @Autowired
    private SlaveFirstApiMapper slaveFirstApiMapper;
    @Autowired
    private SlaveSecondApiMapper slaveSecondApiMapper;

    @Override
    public JsonResult defaultTest()
    {
        return new JsonResult(true, "", apiMapper.getAllItemInfo());
    }

    @Override
    public JsonResult dsTestS1()
    {
        return new JsonResult(true, "", slaveFirstApiMapper.getAllItemInfo());
    }

    @Override
    public JsonResult dsTestS2()
    {
        return new JsonResult(true, "", slaveSecondApiMapper.getAllItemInfo());
    }
}
