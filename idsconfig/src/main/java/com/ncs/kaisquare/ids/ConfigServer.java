package com.ncs.kaisquare.ids;

import com.ncs.kaisquare.ids.test.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class,args);

    }

    @RestController
    @RequestMapping("/config")
    class Test{
        @Autowired
        private Config config;

        @GetMapping("info")
        public String info(){
            return config.toString();
        }

    }


}
