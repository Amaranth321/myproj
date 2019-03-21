package com.ncs.kaisquare.ids;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CronApp {
    public static void main( String[] args ) {
        SpringApplication.run(CronApp.class,args);
    }
}
