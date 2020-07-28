/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.model;

import com.lelib.ycyocp.runner.YcyRunner;

/**
 * The product whose data is a string.
 * <p>
 * It can be replaced by {@link GenericProduct<String>},
 * the reason why creating a duplicate model here is to in case of too many nested generic type while using {@link YcyRunner}.
 */
public class StringProduct extends GenericProduct<String> {
    protected StringProduct(String data) {
        super(data);
    }

    public static StringProduct of(String data) {
        return new StringProduct(data);
    }
}
