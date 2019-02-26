package com.lance.common.config;

import com.lance.common.core.async.impl.ThreadAsyncServiceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsyncConfiguration
{
    @Bean
    public ThreadAsyncServiceProvider threadAsyncServiceProvider()
    {
        ThreadAsyncServiceProvider threadAsyncServiceProvider = new ThreadAsyncServiceProvider(500);
        return threadAsyncServiceProvider;
    }
}
