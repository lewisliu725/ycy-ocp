package com.leliu.ycyocp.consumer;

import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.Product;

public abstract class AbstractProductTransferConsumer<
        TSourceProduct extends Product,
        TTargetProduct extends Product,
        TConsumeResult extends ConsumeResult> implements YcyConsumer<TSourceProduct, TConsumeResult> {
    private YcyConsumer<TTargetProduct, TConsumeResult> targetConsumer;

    protected AbstractProductTransferConsumer(YcyConsumer<TTargetProduct, TConsumeResult> targetConsumer) {
        this.targetConsumer = targetConsumer;
    }

    @Override
    public TConsumeResult consume(TSourceProduct sourceProduct) {
        TTargetProduct targetProduct = this.transfer(sourceProduct);
        return this.targetConsumer.consume(targetProduct);
    }

    public YcyConsumer<TTargetProduct, TConsumeResult> getTargetConsumer() {
        return targetConsumer;
    }

    protected abstract TTargetProduct transfer(TSourceProduct sourceProduct);
}
