/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.runner;

import com.lelib.ycyocp.consumer.YcyConsumer;
import com.lelib.ycyocp.manager.YcyManager;
import com.lelib.ycyocp.model.ConsumeResult;
import com.lelib.ycyocp.model.EmptyParam;
import com.lelib.ycyocp.model.ProduceParam;
import com.lelib.ycyocp.model.Product;
import com.lelib.ycyocp.producer.YcyProducer;

/**
 * The interface which will take take advantage of {@link YcyManager} to
 * get the instance of {@link YcyProducer} and {@link YcyConsumer},
 * and take advantage of the producer to produce product, then consume the product the by consumer.
 *
 * @param <TParam>
 * @param <TProduct>
 * @param <TResult>
 */
public interface YcyRunner<
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
