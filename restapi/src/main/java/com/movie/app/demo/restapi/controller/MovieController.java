package com.movie.app.demo.restapi.controller;

import com.movie.app.demo.database.MovieService;
import com.movie.app.demo.database.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@EnableAutoConfiguration
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> getMovies() {
        return movieService.findAll();
    }

    @PostMapping("/movies")
    @ResponseBody
    public Movie addMovie(@RequestBody Movie newMovie) {
        newMovie.setRemoved(false);

        return movieService.save(newMovie);
    }

    @GetMapping("/movies/{id}")
    @ResponseBody
    public Movie getMovie(@PathVariable Long id) throws Exception {
        return movieService.findOneById(id).orElseThrow(() -> new Exception("Movie Not Found"));
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
    void removeEmployee(@PathVariable Long id) throws Exception {
        Movie movie = movieService.findOneById(id).orElseThrow(() -> new Exception("Movie not Found"));
        movie.setRemoved(true);
        movieService.save(movie);
    }

    @DeleteMapping("/movies/{id}")
    void deleteEmployee(@PathVariable Long id) throws Exception {
        Movie movie = movieService.findOneById(id).orElseThrow(() -> new Exception("Movie not Found"));
        movieService.delete(movie);
    }
}