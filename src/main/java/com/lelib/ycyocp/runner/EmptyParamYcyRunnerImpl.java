package com.lelib.ycyocp.runner;

import com.lelib.ycyocp.manager.YcyManager;
import com.lelib.ycyocp.model.EmptyParam;
import com.lelib.ycyocp.model.ConsumeResult;
import com.lelib.ycyocp.model.Product;

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
