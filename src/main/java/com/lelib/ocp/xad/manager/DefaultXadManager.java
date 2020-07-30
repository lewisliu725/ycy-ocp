/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ocp.xad.manager;

import com.lelib.ocp.xad.consumer.ConsoleOutputXadConsumerImpl;
import com.lelib.ocp.xad.consumer.XadConsumer;
import com.lelib.ocp.xad.model.ConsumeResult;
import com.lelib.ocp.xad.model.ProduceParam;
import com.lelib.ocp.xad.model.Product;
import com.lelib.ocp.xad.model.StringProduct;
import com.lelib.ocp.xad.producer.DefaultXadProducerImpl;
import com.lelib.ocp.xad.producer.XadProducer;

import java.util.Objects;

/**
 * The default ycy manager, which will take advantage of:
 * 1) {@link DefaultXadProducerImpl} to generated the {@link StringProduct},
 * 2) and consume the product by {@link ConsoleOutputXadConsumerImpl}
 */
public class DefaultXadManager<
        TParam extends ProduceParam,
        TProduct extends Product,
        TConsumeResult extends ConsumeResult> implements XadManager<TParam, TProduct, TConsumeResult> {

    private XadProducer<TParam, TProduct> producer;
    private XadConsumer<TProduct, TConsumeResult> consumer;

    private DefaultXadManager(XadProducer<TParam, TProduct> producer, XadConsumer<TProduct, TConsumeResult> consumer) {
        this.producer = Objects.requireNonNull(producer, "producer");
        this.consumer = Objects.requireNonNull(consumer, "consumer");
    }

    @Override
    public XadProducer<TParam, TProduct> getProducer() {
        return this.producer;
    }

    @Override
    public XadConsumer<TProduct, TConsumeResult> getConsumer() {
        return this.consumer;
    }

    public static <
            TParam extends ProduceParam,
            TProduct extends Product,
            TConsumeResult extends ConsumeResult> DefaultXadManager<TParam, TProduct, TConsumeResult> from(XadProducer<TParam, TProduct> producer, XadConsumer<TProduct, TConsumeResult> consumer) {
        return new DefaultXadManager<>(producer, consumer);
    }
}