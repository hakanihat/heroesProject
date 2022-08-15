package com.tinqin.project.data.repository;

import com.tinqin.project.data.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;


public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie getMovieByMovieNameAndReleaseDate(String movieName, LocalDate releaseDate);
}
