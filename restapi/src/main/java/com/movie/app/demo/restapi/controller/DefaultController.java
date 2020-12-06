package com.movie.app.demo.restapi.controller;

import com.movie.app.demo.database.DatabaseService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan({"com.movie.app.demo.database"})
public class DefaultController {
    private final DatabaseService databaseService;

    public DefaultController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Configured database host: " + this.databaseService.host();
    }

}