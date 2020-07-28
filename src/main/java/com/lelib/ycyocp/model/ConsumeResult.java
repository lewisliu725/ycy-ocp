/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.leliu.ycyocp.model;

import com.leliu.ycyocp.consumer.YcyConsumer;

/**
 * The default consumer result which is used by {@link YcyConsumer#consume(Product)}
 * You can also create your own result model by extend this model.
 */
public class ConsumeResult {
    public static final boolean SUCCEED = true;
    public static final boolean FAILED = false;

    /**
     * True means the consumer consumed the product succeed.
     */
    boolean succeed;

    protected ConsumeResult(boolean succeed) {
        this.succeed = succeed;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public static ConsumeResult succeed() {
        return new ConsumeResult(SUCCEED);
    }

    public static ConsumeResult failed() {
        return new ConsumeResult(FAILED);
    }
}
