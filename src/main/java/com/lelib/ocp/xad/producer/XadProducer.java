/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ocp.xad.producer;

import com.lelib.ocp.xad.model.ProduceParam;
import com.lelib.ocp.xad.model.Product;

/**
 * The interface to generate {@link Product}.
 *
 * @param <TParam>
 * @param <TProduct>
 */
public interface XadProducer<TParam extends ProduceParam, TProduct extends Product> {
    /**
     * Generate a product based on the provided parameter.
     *
     * @param param
     * @return
     */
    TProduct generate(TParam param);
}
