/*
 * Copyright 2020 Lewis Liu. All Rights Reserved.
 */
package com.lelib.ocp.xad;

import com.lelib.ocp.xad.runner.XadRunner;
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
public class XadApplication {
    public static void main(String[] args) {
        SpringApplication.run(XadApplication.class, args);
    }

    @Bean
    public CommandLineRunner executeDefaultYcyRunner(
            ConfigurableApplicationContext ctx,
            @Nullable @Qualifier("DefaultYcyRunner") XadRunner runner) {
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
