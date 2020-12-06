package com.movie.app.demo.database;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(DatabaseConfigurationProperties.class)
public class DatabaseService {

    private final DatabaseConfigurationProperties serviceProperties;

    public DatabaseService(DatabaseConfigurationProperties serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    public String host() {
        return this.serviceProperties.getHost();
    }
}