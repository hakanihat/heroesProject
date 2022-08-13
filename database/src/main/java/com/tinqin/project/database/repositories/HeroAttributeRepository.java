package com.tinqin.project.database.repositories;

import com.tinqin.project.database.entities.HeroAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroAttributeRepository extends JpaRepository<HeroAttribute,Long> {
    //HeroAttribute getHeroAttributeByIntelligenceIsGreaterThanGivenNumber (Integer number);


}
