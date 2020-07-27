package com.leliu.ycyocp.manager;

import com.leliu.ycyocp.consumer.YcyConsumer;
import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.ProduceParam;
import com.leliu.ycyocp.model.Product;
import com.leliu.ycyocp.producer.YcyProducer;

public interface YcyManager<
        TParam extends ProduceParam,
        TProduct extends Product,
        TConsumeResult extends ConsumeResult> {
    YcyProducer<TParam, TProduct> getProducer();

    YcyConsumer<TProduct, TConsumeResult> getConsumer();
}
