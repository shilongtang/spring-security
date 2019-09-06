package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan("com.example.demo.mapper")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

   /* @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        *//*return (ConfigurableEmbeddedServletContainer container) -> {
            container.setSessionTimeout(1, TimeUnit.MINUTES);
        };*//*
    }*/
}
