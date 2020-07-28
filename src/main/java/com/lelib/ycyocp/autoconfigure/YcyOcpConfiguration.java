/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp.autoconfigure;

import com.lelib.ycyocp.manager.DefaultYcyManager;
import com.lelib.ycyocp.manager.YcyManager;
import com.lelib.ycyocp.model.ConsumeResult;
import com.lelib.ycyocp.model.EmptyParam;
import com.lelib.ycyocp.model.StringProduct;
import com.lelib.ycyocp.runner.EmptyParamYcyRunnerImpl;
import com.lelib.ycyocp.runner.YcyRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The Springboot auto configuration class.
 */
@Configuration
public class YcyOcpConfiguration {
    @Bean("DefaultYcyRunner")
    @ConditionalOnMissingBean(YcyRunner.class)
    public YcyRunner<?, ?, ?> defaultYcyRunner(YcyManager<EmptyParam, ?, ?> ycyManager) {
        return EmptyParamYcyRunnerImpl.of(ycyManager);
    }

    @Bean("DefaultYcyManager")
    @ConditionalOnMissingBean(YcyManager.class)
    public YcyManager<EmptyParam, StringProduct, ConsumeResult> defaultConsumerFactory() {
        return new DefaultYcyManager();
    }

}
