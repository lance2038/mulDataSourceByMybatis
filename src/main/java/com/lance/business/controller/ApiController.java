package com.lance.business.controller;

import com.lance.business.service.ApiService;
import com.lance.common.base.model.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p> 接口控制层
 *
 * @author lance
 * @version v0.0.1
 * @since 2018/9/25
 **/
@Slf4j
@Controller
@RequestMapping("/handler")
public class ApiController
{
    /**
     * 接口业务处理类
     */
    @Autowired
    private ApiService apiService;

    /**
     * test
     */
    @ResponseBody
    @RequestMapping(value = "/test")
    public JsonResult test()
    {
        System.out.println("数据源-主");
        System.out.println(apiService.defaultTest());
        System.out.println("数据源-辅1");
        System.out.println(apiService.dsTestS1());
        System.out.println("数据源-辅2");
        System.out.println(apiService.dsTestS2());
        return new JsonResult(true, "测试成功");
    }
}
