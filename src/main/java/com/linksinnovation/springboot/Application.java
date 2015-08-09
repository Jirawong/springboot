package com.linksinnovation.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.linksinnovation.springboot")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
