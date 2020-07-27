package com.leliu.ycyocp.runner;

import com.leliu.ycyocp.consumer.YcyConsumer;
import com.leliu.ycyocp.manager.YcyManager;
import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.EmptyParam;
import com.leliu.ycyocp.model.ProduceParam;
import com.leliu.ycyocp.model.Product;
import com.leliu.ycyocp.producer.YcyProducer;

public class DefaultYcyRunnerImpl<
        TParam extends ProduceParam,
        TProduct extends Product,
        TResult extends ConsumeResult> implements YcyRunner<TParam, TProduct, TResult> {
    private YcyManager<TParam, TProduct, TResult> ycyManager;

    private DefaultYcyRunnerImpl(YcyManager<TParam, TProduct, TResult> ycyManager) {
        this.ycyManager = ycyManager;
    }

    @Override
    public void run(TParam param) {
        YcyProducer<TParam, TProduct> producer = this.ycyManager.getProducer();
        YcyConsumer<TProduct, TResult> consumer = this.ycyManager.getConsumer();

        consumer.consume(producer.generate(param));
    }

    @Override
    public YcyManager<TParam, TProduct, TResult> getYcyManager() {
        return this.ycyManager;
    }

    public static <TParam extends ProduceParam, TProduct extends Product, TResult extends ConsumeResult> DefaultYcyRunnerImpl of(YcyManager<TParam, TProduct, TResult> ycyManager) {
        return new DefaultYcyRunnerImpl(ycyManager);
    }
}
