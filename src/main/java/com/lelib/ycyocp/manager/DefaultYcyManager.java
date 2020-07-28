/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.manager;

import com.lelib.ycyocp.consumer.ConsoleOutputYcyConsumerImpl;
import com.lelib.ycyocp.consumer.YcyConsumer;
import com.lelib.ycyocp.model.EmptyParam;
import com.lelib.ycyocp.model.StringProduct;
import com.lelib.ycyocp.producer.DefaultYcyProducerImpl;
import com.lelib.ycyocp.producer.YcyProducer;
import com.lelib.ycyocp.model.ConsumeResult;

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