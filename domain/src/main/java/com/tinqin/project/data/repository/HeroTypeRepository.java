package com.tinqin.project.data.repository;

import com.tinqin.project.data.entity.HeroType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroTypeRepository extends JpaRepository<HeroType,Long> {
    HeroType getHeroTypeByTypeName(String typeName);

}
