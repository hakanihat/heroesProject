package com.tinqin.project.feign;

import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceResponse;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="hero", url = "http://localhost:8081/")
public interface HeroClient {
    @PostMapping("/getHeroById")
    FeignHeroAppearanceResponse getHeroAppearance(@RequestBody FeignHeroAppearanceRequest feignHeroAppearanceRequest);

    @PostMapping("/getHeroAndAlignment")
    FeignHeroBiographyResponse getHeroBiography(@RequestBody FeignHeroBiographyRequest feignHeroBiographyRequest);


}

