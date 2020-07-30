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

/**
 * The interface which will take take advantage of {@link XadManager} to
 * get the instance of {@link XadProducer} and {@link XadConsumer},
 * and take advantage of the producer to produce product, then consume the product the by consumer.
 *
 * @param <TParam>
 * @param <TProduct>
 * @param <TResult>
 */
public interface XadRunner<
        TParam extends ProduceParam,
        TProduct extends Product,
        TResult extends ConsumeResult> {
    /**
     * Run with null parameter.
     */
    default void run() {
        this.run(null);
    }

    /**
     * The run method
     *
     * @param produceParam
     */
    void run(TParam produceParam);
}
