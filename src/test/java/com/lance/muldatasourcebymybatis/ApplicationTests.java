package com.lance.muldatasourcebymybatis;

import com.lance.business.controller.ApiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests
{
    @Autowired
    private ApiController apiController;

    @Test
    public void contextLoads()
    {
        apiController.test();
    }

}

