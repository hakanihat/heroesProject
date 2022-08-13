package com.tinqin.project.database.repositories;

import com.tinqin.project.database.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero,Long> {
    Hero getHeroByHeroName(String heroName);
}
