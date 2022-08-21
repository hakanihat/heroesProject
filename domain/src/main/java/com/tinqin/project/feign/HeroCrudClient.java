package com.tinqin.project.feign;


import com.tinqin.project.models.hero.db.DBHeroRequest;
import com.tinqin.project.models.hero.db.DBHeroResponse;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceResponse;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyResponse;
import com.tinqin.project.models.hero_fight.db.DBHeroFightRequest;
import com.tinqin.project.models.hero_fight.db.DBHeroFightResponse;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieRequest;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value="heroCrud", url = "http://localhost:8082/")
public interface HeroCrudClient {
    @PostMapping("/getHeroFromDB")
    DBHeroAppearanceResponse checkHero(@RequestBody DBHeroAppearanceRequest dbHeroAppearanceRequest);

    @PostMapping("/getHeroFromDB")
    DBHeroResponse findHero(@RequestBody DBHeroRequest dbHeroRequest);

    @PostMapping("/getHeroFromDB")
    DBHeroBiographyResponse checkHeroAndAlignment(@RequestBody DBHeroBiographyRequest dbHeroBiographyRequest);

    @PostMapping("/getFightResult")
    DBHeroFightResponse getFightResult(@RequestBody DBHeroFightRequest dbHeroFightRequest);

    @PostMapping("/getHeroMovies")
    List<DBHeroMovieResponse> getHeroMovies(@RequestBody DBHeroMovieRequest dbHeroMovieRequest);
}
