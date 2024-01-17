package com.example.eurekaclientdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientDiscoveryApplication.class, args);
    }

}
