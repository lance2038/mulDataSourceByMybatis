package com.lance.common.core.async;

public interface AsyncServiceProvider
{
    void process(Runnable runnable);
}
