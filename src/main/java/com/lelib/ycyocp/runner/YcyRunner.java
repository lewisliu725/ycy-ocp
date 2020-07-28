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
    YcyManager<TParam, TProduct, TResult> getYcyManager();

    void run();
}
