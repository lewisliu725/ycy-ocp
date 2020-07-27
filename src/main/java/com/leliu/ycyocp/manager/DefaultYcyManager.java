package com.leliu.ycyocp.manager;

import com.leliu.ycyocp.consumer.DefaultYcyConsumerImpl;
import com.leliu.ycyocp.consumer.YcyConsumer;
import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.EmptyParam;
import com.leliu.ycyocp.model.StringProduct;
import com.leliu.ycyocp.producer.DefaultYcyProducerImpl;
import com.leliu.ycyocp.producer.YcyProducer;

public class DefaultYcyManager implements YcyManager<EmptyParam, StringProduct, ConsumeResult> {
    @Override
    public YcyProducer<EmptyParam, StringProduct> getProducer() {
        return DefaultYcyProducerImpl.defaultStringInstance();
    }

    @Override
    public YcyConsumer<StringProduct, ConsumeResult> getConsumer() {
        return DefaultYcyConsumerImpl.stringInstance();
    }
}