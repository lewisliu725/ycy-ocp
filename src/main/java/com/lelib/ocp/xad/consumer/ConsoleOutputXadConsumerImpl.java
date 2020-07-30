/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ocp.xad.consumer;

import com.lelib.ocp.xad.model.ConsumeResult;
import com.lelib.ocp.xad.model.Product;

/**
 * The consume who will output the result of {@link Product#stringify()} to the console.
 *
 * @param <TProduct>
 */
public class ConsoleOutputXadConsumerImpl<TProduct extends Product> implements XadConsumer<TProduct, ConsumeResult> {
    private ConsoleOutputXadConsumerImpl() {
    }

    @Override
    public ConsumeResult consume(TProduct prod) {
        System.out.println(prod.stringify());
        return ConsumeResult.succeed();
    }

    public static <TProduct extends Product> ConsoleOutputXadConsumerImpl<TProduct> stringInstance() {
        return new ConsoleOutputXadConsumerImpl<>();
    }

}
