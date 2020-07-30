/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ocp.xad.producer;

import com.lelib.ocp.xad.model.EmptyParam;
import com.lelib.ocp.xad.model.Product;
import com.lelib.ocp.xad.model.StringProduct;

/**
 * The default producer, which will generate a consolid {@link Product}.
 *
 * @param <TProduct>
 */
public class DefaultXadProducerImpl<TProduct extends Product> implements XadProducer<EmptyParam, TProduct> {
    private TProduct product;

    private DefaultXadProducerImpl(TProduct product) {
        this.product = product;
    }

    @Override
    public TProduct generate(EmptyParam param) {
        return this.product;
    }

    public static <TProduct extends Product> DefaultXadProducerImpl<TProduct> of(TProduct product) {
        return new DefaultXadProducerImpl<>(product);
    }

    public static DefaultXadProducerImpl<StringProduct> stringInstance(String message) {
        return of(StringProduct.of(message));
    }
}
