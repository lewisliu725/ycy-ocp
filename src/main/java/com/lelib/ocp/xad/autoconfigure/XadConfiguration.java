/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ocp.xad.autoconfigure;

import com.lelib.ocp.xad.consumer.ConsoleOutputXadConsumerImpl;
import com.lelib.ocp.xad.consumer.XadConsumer;
import com.lelib.ocp.xad.manager.DefaultXadManager;
import com.lelib.ocp.xad.manager.XadManager;
import com.lelib.ocp.xad.model.ConsumeResult;
import com.lelib.ocp.xad.model.EmptyParam;
import com.lelib.ocp.xad.model.ProduceParam;
import com.lelib.ocp.xad.model.Product;
import com.lelib.ocp.xad.producer.DefaultXadProducerImpl;
import com.lelib.ocp.xad.producer.XadProducer;
import com.lelib.ocp.xad.runner.DefaultXadRunnerImpl;
import com.lelib.ocp.xad.runner.XadRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Springboot auto configuration class.
 */
@Configuration
public class XadConfiguration {
    @Value("${ycy.product.string.hello:Hello OCP YCY}")
    private String helloMessage;

    @Bean("DefaultYcyRunner")
    @ConditionalOnMissingBean(XadRunner.class)
    public XadRunner<?, ?, ?> defaultYcyRunner(XadManager<EmptyParam, ?, ?> xadManager) {
        return DefaultXadRunnerImpl.of(xadManager);
    }

    @Bean("DefaultYcyManager")
    @ConditionalOnMissingBean(XadManager.class)
    public <
            TParam extends ProduceParam,
            TProduct extends Product,
            TConsumeResult extends ConsumeResult> XadManager<?, ?, ?> defaultYcyManager(
            XadProducer<TParam, TProduct> xadProducer,
            XadConsumer<TProduct, TConsumeResult> xadConsumer) {
        return DefaultXadManager.from(xadProducer, xadConsumer);
    }

    @Bean("DefaultYcyProducer")
    @ConditionalOnMissingBean(XadProducer.class)
    public XadProducer<?, ?> defaultYcyProducer() {
        return DefaultXadProducerImpl.stringInstance(this.helloMessage);
    }

    @Bean("DefaultYcyConsumer")
    @ConditionalOnMissingBean(XadConsumer.class)
    public XadConsumer<?, ?> defaultYcyConsumer() {
        return ConsoleOutputXadConsumerImpl.stringInstance();
    }

}
