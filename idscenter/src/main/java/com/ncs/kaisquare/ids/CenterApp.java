package com.ncs.kaisquare.ids;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CenterApp {

    public static void main(String[] args) {
        SpringApplication.run(CenterApp.class,args);
    }
}
