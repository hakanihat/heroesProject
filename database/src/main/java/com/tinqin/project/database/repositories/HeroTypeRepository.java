package com.tinqin.project.database.repositories;

import com.tinqin.project.database.entities.HeroType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroTypeRepository extends JpaRepository<HeroType,Long> {

    HeroType getHeroTypeByTypeName(String typeName);

}
