/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.producer;

import com.lelib.ycyocp.model.EmptyParam;
import com.lelib.ycyocp.model.StringProduct;
import com.lelib.ycyocp.model.Product;

/**
 * The default producer, which will generate a consolid {@link Product}.
 *
 * @param <TProduct>
 */
public class DefaultYcyProducerImpl<TProduct extends Product> implements YcyProducer<EmptyParam, TProduct> {

    public static final String HELLO_OCP_YCY = "Hello OCP YCY";

    private TProduct product;

    private DefaultYcyProducerImpl(TProduct product) {
        this.product = product;
    }

    @Override
    public TProduct generate(EmptyParam param) {
        return this.product;
    }

    public static <TProduct extends Product> DefaultYcyProducerImpl<TProduct> of(TProduct product) {
        return new DefaultYcyProducerImpl<>(product);
    }

    public static DefaultYcyProducerImpl<StringProduct> defaultStringInstance() {
        return of(StringProduct.of(HELLO_OCP_YCY));
    }
}
