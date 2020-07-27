package com.leliu.ycyocp.consumer;

import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.Product;

public interface YcyConsumer<TProduct extends Product, TConsumeResult extends ConsumeResult> {
    TConsumeResult consume(TProduct product);
}
