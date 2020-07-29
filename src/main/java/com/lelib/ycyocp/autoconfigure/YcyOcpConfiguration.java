/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.autoconfigure;

import com.lelib.ycyocp.consumer.ConsoleOutputYcyConsumerImpl;
import com.lelib.ycyocp.consumer.YcyConsumer;
import com.lelib.ycyocp.manager.DefaultYcyManager;
import com.lelib.ycyocp.manager.YcyManager;
import com.lelib.ycyocp.model.*;
import com.lelib.ycyocp.producer.DefaultYcyProducerImpl;
import com.lelib.ycyocp.producer.YcyProducer;
import com.lelib.ycyocp.runner.DefaultYcyRunnerImpl;
import com.lelib.ycyocp.runner.YcyRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Springboot auto configuration class.
 */
@Configuration
public class YcyOcpConfiguration {
    @Value("${ycy.product.string.hello:Hello OCP YCY}")
    private String helloMessage;

    @Bean("DefaultYcyRunner")
    @ConditionalOnMissingBean(YcyRunner.class)
    public YcyRunner<?, ?, ?> defaultYcyRunner(YcyManager<EmptyParam, ?, ?> ycyManager) {
        return DefaultYcyRunnerImpl.of(ycyManager);
    }

    @Bean("DefaultYcyManager")
    @ConditionalOnMissingBean(YcyManager.class)
    public <
            TParam extends ProduceParam,
            TProduct extends Product,
            TConsumeResult extends ConsumeResult> YcyManager<?, ?, ?> defaultYcyManager(
            YcyProducer<TParam, TProduct> ycyProducer,
            YcyConsumer<TProduct, TConsumeResult> ycyConsumer) {
        return DefaultYcyManager.from(ycyProducer, ycyConsumer);
    }

    @Bean("DefaultYcyProducer")
    @ConditionalOnMissingBean(YcyProducer.class)
    public YcyProducer<?, ?> defaultYcyProducer() {
        return DefaultYcyProducerImpl.stringInstance(this.helloMessage);
    }

    @Bean("DefaultYcyConsumer")
    @ConditionalOnMissingBean(YcyConsumer.class)
    public YcyConsumer<?, ?> defaultYcyConsumer() {
        return ConsoleOutputYcyConsumerImpl.stringInstance();
    }

}
