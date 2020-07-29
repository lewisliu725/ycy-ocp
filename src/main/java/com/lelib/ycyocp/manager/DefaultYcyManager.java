/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.manager;

import com.lelib.ycyocp.consumer.ConsoleOutputYcyConsumerImpl;
import com.lelib.ycyocp.consumer.YcyConsumer;
import com.lelib.ycyocp.model.*;
import com.lelib.ycyocp.producer.DefaultYcyProducerImpl;
import com.lelib.ycyocp.producer.YcyProducer;
import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

/**
 * The default ycy manager, which will take advantage of:
 * 1) {@link DefaultYcyProducerImpl} to generated the {@link StringProduct},
 * 2) and consume the product by {@link ConsoleOutputYcyConsumerImpl}
 */
public class DefaultYcyManager<
        TParam extends ProduceParam,
        TProduct extends Product,
        TConsumeResult extends ConsumeResult> implements YcyManager<TParam, TProduct, TConsumeResult> {

    private YcyProducer<TParam, TProduct> producer;
    private YcyConsumer<TProduct, TConsumeResult> consumer;

    private DefaultYcyManager(YcyProducer<TParam, TProduct> producer, YcyConsumer<TProduct, TConsumeResult> consumer) {
        this.producer = Objects.requireNonNull(producer, "producer");
        this.consumer = Objects.requireNonNull(consumer, "consumer");
    }

    @Override
    public YcyProducer<TParam, TProduct> getProducer() {
        return this.producer;
    }

    @Override
    public YcyConsumer<TProduct, TConsumeResult> getConsumer() {
        return this.consumer;
    }

    public static <
            TParam extends ProduceParam,
            TProduct extends Product,
            TConsumeResult extends ConsumeResult> DefaultYcyManager<TParam, TProduct, TConsumeResult> from(YcyProducer<TParam, TProduct> producer, YcyConsumer<TProduct, TConsumeResult> consumer) {
        return new DefaultYcyManager<>(producer, consumer);
    }
}