/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ycyocp;

import com.lelib.ycyocp.runner.YcyRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;

/**
 * The entry class of the demo application.
 */
@SpringBootApplication
public class YcyOcpApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcyOcpApplication.class, args);
    }

    @Bean
    public CommandLineRunner executeDefaultYcyRunner(
            ConfigurableApplicationContext ctx,
            @Nullable @Qualifier("DefaultYcyRunner") YcyRunner runner) {
        return (args) -> {
            if (runner == null) {
                // TODO Use log instead
                System.out.println("[Warning] Cannot find the default runner.");
                return;
            }
            runner.run();
        };
    }
}
