package com.tinqin.project.database.repositories;

import com.tinqin.project.database.entities.MoviesOfTheHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesOfTheHeroRepository extends JpaRepository<MoviesOfTheHero,Long> {

    MoviesOfTheHero getMoviesOfTheHeroByHero_IdHero(Long idHero);
}
