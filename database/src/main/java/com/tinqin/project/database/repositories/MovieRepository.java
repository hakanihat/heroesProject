package com.tinqin.project.database.repositories;

import com.tinqin.project.database.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie getMovieByMovieNameAndReleaseDate(String movieName, Date releaseDate);
}
