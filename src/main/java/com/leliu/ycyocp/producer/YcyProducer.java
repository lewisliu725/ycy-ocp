package com.leliu.ycyocp.producer;

import com.leliu.ycyocp.model.ProduceParam;
import com.leliu.ycyocp.model.Product;

public interface YcyProducer<TParam extends ProduceParam, TProduct extends Product> {
    TProduct generate(TParam param);
}
