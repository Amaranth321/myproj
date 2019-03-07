package com.ncs.kaisquare.ids.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.cloud.config.server.git")
public class Config {

    private String username;
    private String password;
    private String uri;
    private String searchPaths;

    @Override
    public String toString() {
        return "Config{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uri='" + uri + '\'' +
                ", searchPaths='" + searchPaths + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSearchPaths() {
        return searchPaths;
    }

    public void setSearchPaths(String searchPaths) {
        this.searchPaths = searchPaths;
    }
}
