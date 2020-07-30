/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ocp.xad.manager;

import com.lelib.ocp.xad.consumer.XadConsumer;
import com.lelib.ocp.xad.model.ConsumeResult;
import com.lelib.ocp.xad.model.ProduceParam;
import com.lelib.ocp.xad.model.Product;
import com.lelib.ocp.xad.producer.XadProducer;

/**
 * The interface which is used to composite the {@link XadProducer} and {@link XadConsumer},
 * and restrict them to use the same {@link Product}.
 *
 * @param <TParam>
 * @param <TProduct>
 * @param <TConsumeResult>
 */
public interface XadManager<
        TParam extends ProduceParam,
        TProduct extends Product,
        TConsumeResult extends ConsumeResult> {
    /**
     * Get the instance of producer.
     *
     * @return
     */
    XadProducer<TParam, TProduct> getProducer();

    /**
     * Get the instance of consumer.
     *
     * @return
     */
    XadConsumer<TProduct, TConsumeResult> getConsumer();
}
