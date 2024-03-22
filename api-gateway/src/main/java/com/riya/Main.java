package com.riya;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}