package com.movie.app.demo.database.repository;

import com.movie.app.demo.database.entity.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
