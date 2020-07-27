package com.leliu.ycyocp.consumer;

import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.Product;

public class DefaultYcyConsumerImpl<TProduct extends Product> implements YcyConsumer<TProduct, ConsumeResult> {
    private DefaultYcyConsumerImpl() {
    }

    @Override
    public ConsumeResult consume(TProduct prod) {
        System.out.println(prod.stringify());
        return ConsumeResult.succeed();
    }

    public static <TProduct extends Product> DefaultYcyConsumerImpl<TProduct> stringInstance() {
        return new DefaultYcyConsumerImpl<>();
    }

}
