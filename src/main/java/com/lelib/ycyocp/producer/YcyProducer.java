/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.leliu.ycyocp.producer;

import com.leliu.ycyocp.model.ProduceParam;
import com.leliu.ycyocp.model.Product;

/**
 * The interface to generate {@link Product}.
 *
 * @param <TParam>
 * @param <TProduct>
 */
public interface YcyProducer<TParam extends ProduceParam, TProduct extends Product> {
    /**
     * Generate a product based on the provided parameter.
     *
     * @param param
     * @return
     */
    TProduct generate(TParam param);
}
