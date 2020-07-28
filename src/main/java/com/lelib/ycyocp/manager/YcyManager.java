/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.manager;

import com.lelib.ycyocp.consumer.YcyConsumer;
import com.lelib.ycyocp.producer.YcyProducer;
import com.lelib.ycyocp.model.ConsumeResult;
import com.lelib.ycyocp.model.ProduceParam;
import com.lelib.ycyocp.model.Product;

/**
 * The interface which is used to composite the {@link YcyProducer} and {@link YcyConsumer},
 * and restrict them to use the same {@link Product}.
 *
 * @param <TParam>
 * @param <TProduct>
 * @param <TConsumeResult>
 */
public interface YcyManager<
        TParam extends ProduceParam,
        TProduct extends Product,
        TConsumeResult extends ConsumeResult> {
    /**
     * Get the instance of producer.
     *
     * @return
     */
    YcyProducer<TParam, TProduct> getProducer();

    /**
     * Get the instance of consumer.
     *
     * @return
     */
    YcyConsumer<TProduct, TConsumeResult> getConsumer();
}
