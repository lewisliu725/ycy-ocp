/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.leliu.ycyocp.manager;

import com.leliu.ycyocp.consumer.ConsoleOutputYcyConsumerImpl;
import com.leliu.ycyocp.consumer.YcyConsumer;
import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.EmptyParam;
import com.leliu.ycyocp.model.StringProduct;
import com.leliu.ycyocp.producer.DefaultYcyProducerImpl;
import com.leliu.ycyocp.producer.YcyProducer;

/**
 * The default ycy manager, which will take advantage of:
 * 1) {@link DefaultYcyProducerImpl} to generated the {@link StringProduct},
 * 2) and consume the product by {@link ConsoleOutputYcyConsumerImpl}
 */
public class DefaultYcyManager implements YcyManager<EmptyParam, StringProduct, ConsumeResult> {
    @Override
    public YcyProducer<EmptyParam, StringProduct> getProducer() {
        return DefaultYcyProducerImpl.defaultStringInstance();
    }

    @Override
    public YcyConsumer<StringProduct, ConsumeResult> getConsumer() {
        return ConsoleOutputYcyConsumerImpl.stringInstance();
    }
}