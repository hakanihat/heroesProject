package com.tinqin.project.feign;

import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="heroCrud", url = "http://localhost:8082/")
public interface HeroCrudClient {
    @PostMapping("/getHeroFromDB")
    DBHeroAppearanceResponse checkHero(@RequestBody DBHeroAppearanceRequest dbHeroAppearanceRequest);
}
