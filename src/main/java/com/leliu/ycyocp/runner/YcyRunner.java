package com.leliu.ycyocp.runner;

import com.leliu.ycyocp.manager.YcyManager;
import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.ProduceParam;
import com.leliu.ycyocp.model.Product;

public interface YcyRunner<
        TParam extends ProduceParam,
        TProduct extends Product,
        TResult extends ConsumeResult> {
    YcyManager<TParam, TProduct, TResult> getYcyManager();

    void run(TParam param);
}
