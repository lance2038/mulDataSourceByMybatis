package com.lance.common.core.async.impl;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lance.common.core.async.AsyncServiceProvider;

import java.util.concurrent.*;

/**
 * 线程池
 *
 * @author lance
 */
public class ThreadAsyncServiceProvider implements AsyncServiceProvider
{
    private ExecutorService executorService = null;
    private int maxPoolSize = 50;

    public ThreadAsyncServiceProvider()
    {
        this.init();
    }

    public ThreadAsyncServiceProvider(int maxPoolSize)
    {
        this.maxPoolSize = maxPoolSize;
        this.init();
    }

    private void init()
    {
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("Async-pool-%d").build();
        this.executorService = new ThreadPoolExecutor(5, maxPoolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), factory, new ThreadPoolExecutor.AbortPolicy());
    }

    @Override
    public void process(Runnable runnable)
    {
        this.executorService.execute(runnable);
    }
}
