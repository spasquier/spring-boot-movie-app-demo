package com.movie.app.demo.database;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("database-service.host=db")
public class DatabaseServiceTest {

    @Autowired
    private DatabaseService databaseService;

    @Test
    public void contextLoads() {
        assertThat(databaseService.host()).isNotNull();
    }

    @SpringBootApplication
    static class TestConfiguration {
    }

}