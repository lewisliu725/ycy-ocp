package com.leliu.ycyocp.autoconfigure;

import com.leliu.ycyocp.manager.DefaultYcyManager;
import com.leliu.ycyocp.manager.YcyManager;
import com.leliu.ycyocp.model.ConsumeResult;
import com.leliu.ycyocp.model.EmptyParam;
import com.leliu.ycyocp.model.StringProduct;
import com.leliu.ycyocp.runner.DefaultYcyRunnerImpl;
import com.leliu.ycyocp.runner.YcyRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.leliu")
public class YcyOcpConfiguration {
    @Bean("DefaultYcyRunner")
    @ConditionalOnMissingBean(YcyRunner.class)
    public YcyRunner<?, ?, ?> defaultYcyRunner(YcyManager<?, ?, ?> ycyManager) {
        return DefaultYcyRunnerImpl.of(ycyManager);
    }

    @Bean("DefaultYcyManager")
    @ConditionalOnMissingBean(YcyManager.class)
    public YcyManager<EmptyParam, StringProduct, ConsumeResult> defaultConsumerFactory() {
        return new DefaultYcyManager();
    }

}
