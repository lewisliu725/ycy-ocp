/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.leliu.ycyocp;

import com.leliu.ycyocp.model.EmptyParam;
import com.leliu.ycyocp.runner.YcyRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.leliu")
public class YcyOcpApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcyOcpApplication.class, args);
    }

    @Bean
    public CommandLineRunner executeYcyRunner(ConfigurableApplicationContext ctx, YcyRunner runner) {
        return (args) -> {
            runner.run();
        };
    }
}
