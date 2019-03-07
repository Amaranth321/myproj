package com.ncs.kaisquare.ids.controller;

import com.ncs.kaisquare.ids.config.NodeServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configtest")
public class ConfigTestController {

    @Autowired
    private NodeServerConfig nodeServerConfig;

    @GetMapping("/getConfig")
    public String getConfig(){
        return nodeServerConfig.toString();
    }
}
