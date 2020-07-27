package com.leliu.ycyocp.model;

public abstract class Product {
    public abstract String stringify();

    @Override
    public String toString() {
        return this.stringify();
    }
}
