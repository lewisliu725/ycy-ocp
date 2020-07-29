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

import java.util.Objects;

/**
 * The abstract runner, which provide skeleton implementation of a common runner.
 *
 * @param <TParam>
 * @param <TProduct>
 * @param <TResult>
 */
public class DefaultYcyRunnerImpl<
        TParam extends ProduceParam,
        TProduct extends Product,
        TResult extends ConsumeResult> implements YcyRunner<TParam, TProduct, TResult> {
    private YcyManager<TParam, TProduct, TResult> ycyManager;

    protected DefaultYcyRunnerImpl(YcyManager<TParam, TProduct, TResult> ycyManager) {
        this.ycyManager = Objects.requireNonNull(ycyManager, "ycyManager");
    }

    @Override
    public void run(TParam produceParam) {
        YcyProducer<TParam, TProduct> producer = this.ycyManager.getProducer();
        YcyConsumer<TProduct, TResult> consumer = this.ycyManager.getConsumer();

        consumer.consume(producer.generate(produceParam));
    }

    public static <
            TParam extends ProduceParam,
            TProduct extends Product,
            TResult extends ConsumeResult> DefaultYcyRunnerImpl<TParam, TProduct, TResult> of(YcyManager<TParam, TProduct, TResult> ycyManager) {
        return new DefaultYcyRunnerImpl<>(ycyManager);
    }
}
