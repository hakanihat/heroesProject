package com.tinqin.project.feign;

import com.tinqin.project.models.DBHeroRequest;
import com.tinqin.project.models.DBHeroResponse;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceResponse;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="heroCrud", url = "http://localhost:8082/")
public interface HeroCrudClient {
    @PostMapping("/getHeroFromDB")
    DBHeroAppearanceResponse checkHero(@RequestBody DBHeroRequest dbHeroRequest);

    @PostMapping("/getAlignmentFromDB")
    DBHeroBiographyResponse checkHeroAndAlignment(@RequestBody DBHeroResponse dbHeroResponse);
}
