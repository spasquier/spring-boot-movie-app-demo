package com.movie.app.demo.database;

import com.movie.app.demo.database.entity.Movie;
import com.movie.app.demo.database.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAll() {
        return (List<Movie>) repository.findAll();
    }

    public Optional<Movie> findOneById(long id) throws Exception {
       return repository.findById(id);
    }

    public Movie save(Movie movie) {
        repository.save(movie);

        return movie;
    }

    public void remove(Movie movie) {
        movie.setRemoved(true);
        repository.save(movie);
    }

    public void delete(Movie movie) {
        repository.delete(movie);
    }
}