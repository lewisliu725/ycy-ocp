package com.leliu.ycyocp.model;

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
