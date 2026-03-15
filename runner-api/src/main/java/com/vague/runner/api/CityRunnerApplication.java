package com.vague.runner.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.vague.runner")
public class CityRunnerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CityRunnerApplication.class, args);
    }
}
