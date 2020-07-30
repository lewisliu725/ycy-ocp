/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ocp.xad.consumer;

import com.lelib.ocp.xad.model.ConsumeResult;
import com.lelib.ocp.xad.model.Product;
import com.lelib.ocp.xad.producer.XadProducer;

import java.util.Objects;

/**
 * The abstract decorator which can be used to adapter the target consumer.
 * <p>
 * It's often used when the {@link Product} generated by the {@link XadProducer} is different from
 * the one consumed by the {@link XadConsumer}.
 *
 * @param <TSourceProduct>
 * @param <TTargetProduct>
 * @param <TConsumeResult>
 */
public abstract class AbstractProductTransferConsumer<
        TSourceProduct extends Product,
        TTargetProduct extends Product,
        TConsumeResult extends ConsumeResult> implements XadConsumer<TSourceProduct, TConsumeResult> {
    private XadConsumer<TTargetProduct, TConsumeResult> targetConsumer;

    protected AbstractProductTransferConsumer(XadConsumer<TTargetProduct, TConsumeResult> targetConsumer) {
        this.targetConsumer = Objects.requireNonNull(targetConsumer, "targetConsumer");
    }

    @Override
    public TConsumeResult consume(TSourceProduct sourceProduct) {
        TTargetProduct targetProduct = this.transfer(sourceProduct);
        return this.targetConsumer.consume(targetProduct);
    }

    public XadConsumer<TTargetProduct, TConsumeResult> getTargetConsumer() {
        return targetConsumer;
    }

    protected abstract TTargetProduct transfer(TSourceProduct sourceProduct);
}