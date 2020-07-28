/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.model;

/**
 * The generic product.
 * <p>
 * It's often used when the data in the product is a single data model, e.g. String.
 *
 * @param <TData>
 */
public class GenericProduct<TData> extends Product {
    TData data;

    protected GenericProduct(TData data) {
        this.data = data;
    }

    public TData getData() {
        return data;
    }

    @Override
    public String stringify() {
        return String.valueOf(this.data);
    }

    public static <TData> GenericProduct<TData> of(TData data) {
        return new GenericProduct<TData>(data);
    }
}
