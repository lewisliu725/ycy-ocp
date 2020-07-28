/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.runner;

import com.lelib.ycyocp.consumer.YcyConsumer;
import com.lelib.ycyocp.manager.YcyManager;
import com.lelib.ycyocp.model.ConsumeResult;
import com.lelib.ycyocp.model.ProduceParam;
import com.lelib.ycyocp.model.Product;
import com.lelib.ycyocp.producer.YcyProducer;

/**
 * The abstract runner, which provide skeleton implementation of a common runner.
 *
 * @param <TParam>
 * @param <TProduct>
 * @param <TResult>
 */
public abstract class AbstractYcyRunnerImpl<
        TParam extends ProduceParam,
        TProduct extends Product,
        TResult extends ConsumeResult> implements YcyRunner<TParam, TProduct, TResult> {
    private YcyManager<TParam, TProduct, TResult> ycyManager;

    protected AbstractYcyRunnerImpl(YcyManager<TParam, TProduct, TResult> ycyManager) {
        this.ycyManager = ycyManager;
    }

    @Override
    public void run() {
        YcyProducer<TParam, TProduct> producer = this.ycyManager.getProducer();
        YcyConsumer<TProduct, TResult> consumer = this.ycyManager.getConsumer();

        TParam param = getProduceParam();
        consumer.consume(producer.generate(param));
    }

    @Override
    public YcyManager<TParam, TProduct, TResult> getYcyManager() {
        return this.ycyManager;
    }

    /**
     * The abstract method which is used to get / load / generated the parameter to produce a product.
     *
     * @return
     */
    protected abstract TParam getProduceParam();
}
