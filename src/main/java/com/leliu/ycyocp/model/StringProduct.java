package com.leliu.ycyocp.model;

public class StringProduct extends GenericProduct<String> {
    protected StringProduct(String data) {
        super(data);
    }

    public static StringProduct of(String data) {
        return new StringProduct(data);
    }
}
