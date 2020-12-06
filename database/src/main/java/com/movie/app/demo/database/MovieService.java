package com.movie.app.demo.database;

import com.movie.app.demo.database.entity.Movie;
import com.movie.app.demo.database.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAll() {
        return (List<Movie>) repository.findAll();
    }
}