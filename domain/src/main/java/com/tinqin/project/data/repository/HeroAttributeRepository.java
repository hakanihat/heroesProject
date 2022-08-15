package com.tinqin.project.data.repository;

import com.tinqin.project.data.entity.HeroAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroAttributeRepository extends JpaRepository<HeroAttribute,Long> {
    //HeroAttribute getHeroAttributeByIntelligenceIsGreaterThanGivenNumber (Integer number);


}
