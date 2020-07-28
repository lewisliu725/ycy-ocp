/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.leliu.ycyocp.consumer;

import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.Product;

/**
 * The consume who will output the result of {@link Product#stringify()} to the console.
 *
 * @param <TProduct>
 */
public class ConsoleOutputYcyConsumerImpl<TProduct extends Product> implements YcyConsumer<TProduct, ConsumeResult> {
    private ConsoleOutputYcyConsumerImpl() {
    }

    @Override
    public ConsumeResult consume(TProduct prod) {
        System.out.println(prod.stringify());
        return ConsumeResult.succeed();
    }

    public static <TProduct extends Product> ConsoleOutputYcyConsumerImpl<TProduct> stringInstance() {
        return new ConsoleOutputYcyConsumerImpl<>();
    }

}
