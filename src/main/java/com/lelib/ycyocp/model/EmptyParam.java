/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.model;

import com.lelib.ycyocp.producer.YcyProducer;

/**
 * The empty produce parameter.
 * <p>
 * It's often used when the {@link YcyProducer} doesn't care about the parameter while producing {@link Product}.
 */
public class EmptyParam implements ProduceParam {
    private static EmptyParam instance;

    private EmptyParam() {
        if (instance != null) {
            throw new IllegalStateException("Use getInstance() method to create");
        }
    }

    public static EmptyParam getInstance() {
        if (instance == null) {
            synchronized (EmptyParam.class) {
                if (instance == null) {
                    instance = new EmptyParam();
                }
            }
        }
        return instance;
    }
}
