package com.ncs.kaisquare.ids.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class NodeServerConfig {

    @Value(value = "${node.cloudServer.host}")
    private String cloudServerHost;
    @Value(value = "${node.cloudServer.port}")
    private int cloudServerPort;
    @Value(value = "${node.coreEngine.host}")
    private String coreEngineHost;
    @Value(value = "${node.coreEngine.ports.streamControl}")
    private int streamControlPort;
    @Value(value = "${node.coreEngine.ports.data}")
    private String coreEngineDataPort;
    @Value(value = "${node.coreEngine.ports.deviceManagement}")
    private int deviceMgtPort;
    @Value(value = "${node.coreEngine.ports.deviceControl}")
    private String deviceControlPort;
    @Value(value = "${node.coreEngine.ports.arbiterManagement}")
    private int arbiterMgtPort;
    @Value(value = "${node.coreEngine.ports.config}")
    private int coreEngineConfigPort;


    public String getCloudServerHost() {
        return cloudServerHost;
    }

    public void setCloudServerHost(String cloudServerHost) {
        this.cloudServerHost = cloudServerHost;
    }

    public int getCloudServerPort() {
        return cloudServerPort;
    }

    public void setCloudServerPort(int cloudServerPort) {
        this.cloudServerPort = cloudServerPort;
    }

    public String getCoreEngineHost() {
        return coreEngineHost;
    }

    public void setCoreEngineHost(String coreEngineHost) {
        this.coreEngineHost = coreEngineHost;
    }

    public int getStreamControlPort() {
        return streamControlPort;
    }

    public void setStreamControlPort(int streamControlPort) {
        this.streamControlPort = streamControlPort;
    }

    public String getCoreEngineDataPort() {
        return coreEngineDataPort;
    }

    public void setCoreEngineDataPort(String coreEngineDataPort) {
        this.coreEngineDataPort = coreEngineDataPort;
    }

    public int getDeviceMgtPort() {
        return deviceMgtPort;
    }

    public void setDeviceMgtPort(int deviceMgtPort) {
        this.deviceMgtPort = deviceMgtPort;
    }

    public String getDeviceControlPort() {
        return deviceControlPort;
    }

    public void setDeviceControlPort(String deviceControlPort) {
        this.deviceControlPort = deviceControlPort;
    }

    public int getArbiterMgtPort() {
        return arbiterMgtPort;
    }

    public void setArbiterMgtPort(int arbiterMgtPort) {
        this.arbiterMgtPort = arbiterMgtPort;
    }

    public int getCoreEngineConfigPort() {
        return coreEngineConfigPort;
    }

    public void setCoreEngineConfigPort(int coreEngineConfigPort) {
        this.coreEngineConfigPort = coreEngineConfigPort;
    }

    @Override
    public String toString() {
        return "NodeServerConfig{" +
                "cloudServerHost='" + cloudServerHost + '\'' +
                ", cloudServerPort=" + cloudServerPort +
                ", coreEngineHost='" + coreEngineHost + '\'' +
                ", streamControlPort=" + streamControlPort +
                ", coreEngineDataPort='" + coreEngineDataPort + '\'' +
                ", deviceMgtPort=" + deviceMgtPort +
                ", deviceControlPort='" + deviceControlPort + '\'' +
                ", arbiterMgtPort=" + arbiterMgtPort +
                ", coreEngineConfigPort=" + coreEngineConfigPort +
                '}';
    }
}
