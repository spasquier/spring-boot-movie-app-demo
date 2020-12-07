package com.movie.app.demo.restapi.controller;

import com.movie.app.demo.database.MovieService;
import com.movie.app.demo.database.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@EnableAutoConfiguration
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> getMovies() {
        return movieService.findAll().stream().filter(movie -> !movie.isRemoved()).collect(Collectors.toList());
    }

    @PostMapping("/movies")
    @ResponseBody
    public Movie addMovie(@RequestBody Movie newMovie) {
        newMovie.setRemoved(false);
        movieService.save(newMovie);

        return newMovie;
    }

    @GetMapping("/movies/{id}")
    @ResponseBody
    public Movie getMovie(@PathVariable Long id) throws Exception {
        return movieService.findOneById(id).filter(movie -> !movie.isRemoved())
                .orElseThrow(() -> new Exception("Movie Not Found"));
    }

    @PutMapping("/movies/{id}")
    @ResponseBody
    public Movie replaceMovie(@PathVariable Long id, @RequestBody Movie newMovie) throws Exception {
        return movieService.findOneById(id)
            .map(movie -> {
                movie.setTitle(newMovie.getTitle());
                movie.setDescription(newMovie.getDescription());
                movie.setImage(newMovie.getImage());
                movie.setAvailability(newMovie.getAvailability());
                movie.setRentalPrice(newMovie.getRentalPrice());
                movie.setSalePrice(newMovie.getSalePrice());
                return movieService.save(movie);
            })
            .orElseGet(() -> {
                newMovie.setId(id);
                newMovie.setRemoved(false);
                return movieService.save(newMovie);
            });
    }

    @DeleteMapping("/movies/{id}/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeEmployee(@PathVariable Long id) throws Exception {
        Movie movie = movieService.findOneById(id).orElseThrow(() -> new Exception("Movie not Found"));
        movie.setRemoved(true);
        movieService.save(movie);
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEmployee(@PathVariable Long id) throws Exception {
        Movie movie = movieService.findOneById(id).orElseThrow(() -> new Exception("Movie not Found"));
        movieService.delete(movie);
    }
}