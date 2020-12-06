package com.movie.app.demo.restapi.controller;

import com.movie.app.demo.database.MovieService;
import com.movie.app.demo.database.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@EnableAutoConfiguration
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> index() {
        return movieService.findAll();
    }

}