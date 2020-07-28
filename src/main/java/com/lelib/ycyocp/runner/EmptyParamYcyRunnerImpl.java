package com.leliu.ycyocp.runner;

import com.leliu.ycyocp.manager.YcyManager;
import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.EmptyParam;
import com.leliu.ycyocp.model.Product;

/**
 * The default runner, which take advantage of {@link EmptyParam} to generate the product, then consume it.
 *
 * @param <TProduct>
 * @param <TResult>
 */
public class EmptyParamYcyRunnerImpl<
        TProduct extends Product,
        TResult extends ConsumeResult> extends AbstractYcyRunnerImpl<EmptyParam, TProduct, TResult> {
    protected EmptyParamYcyRunnerImpl(YcyManager<EmptyParam, TProduct, TResult> ycyManager) {
        super(ycyManager);
    }

    @Override
    protected EmptyParam getProduceParam() {
        return EmptyParam.getInstance();
    }

    public static <TProduct extends Product, TResult extends ConsumeResult> AbstractYcyRunnerImpl<EmptyParam, TProduct, TResult> of(YcyManager<EmptyParam, TProduct, TResult> ycyManager) {
        return new EmptyParamYcyRunnerImpl<>(ycyManager);
    }
}
