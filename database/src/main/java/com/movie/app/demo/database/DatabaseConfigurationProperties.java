package com.movie.app.demo.database;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("database-service")
public class DatabaseConfigurationProperties {

    /**
     * Database host
     */
    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}