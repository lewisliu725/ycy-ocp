/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ocp.xad.runner;

import com.lelib.ocp.xad.consumer.XadConsumer;
import com.lelib.ocp.xad.manager.XadManager;
import com.lelib.ocp.xad.model.ConsumeResult;
import com.lelib.ocp.xad.model.ProduceParam;
import com.lelib.ocp.xad.model.Product;
import com.lelib.ocp.xad.producer.XadProducer;

import java.util.Objects;

/**
 * The abstract runner, which provide skeleton implementation of a common runner.
 *
 * @param <TParam>
 * @param <TProduct>
 * @param <TResult>
 */
public class DefaultXadRunnerImpl<
        TParam extends ProduceParam,
        TProduct extends Product,
        TResult extends ConsumeResult> implements XadRunner<TParam, TProduct, TResult> {
    private XadManager<TParam, TProduct, TResult> xadManager;

    protected DefaultXadRunnerImpl(XadManager<TParam, TProduct, TResult> xadManager) {
        this.xadManager = Objects.requireNonNull(xadManager, "ycyManager");
    }

    @Override
    public void run(TParam produceParam) {
        XadProducer<TParam, TProduct> producer = this.xadManager.getProducer();
        XadConsumer<TProduct, TResult> consumer = this.xadManager.getConsumer();

        consumer.consume(producer.generate(produceParam));
    }

    public static <
            TParam extends ProduceParam,
            TProduct extends Product,
            TResult extends ConsumeResult> DefaultXadRunnerImpl<TParam, TProduct, TResult> of(XadManager<TParam, TProduct, TResult> xadManager) {
        return new DefaultXadRunnerImpl<>(xadManager);
    }
}
