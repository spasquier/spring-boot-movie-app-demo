package com.movie.app.demo.database.repository;

import com.movie.app.demo.database.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
