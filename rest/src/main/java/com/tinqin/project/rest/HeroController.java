package com.tinqin.project.rest;

import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero_appearance.HeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.HeroAppearanceResponse;
import com.tinqin.project.models.hero_biography.HeroBiographyRequest;
import com.tinqin.project.models.hero_biography.HeroBiographyResponse;
import com.tinqin.project.models.hero_fight.HeroFightRequest;
import com.tinqin.project.models.hero_fight.HeroFightResponse;
import com.tinqin.project.models.hero_movie.HeroMovieRequest;
import com.tinqin.project.models.hero_movie.HeroMovieResponse;
import com.tinqin.project.operation.HeroAppearanceProcessor;
import com.tinqin.project.operation.HeroBiographyProcessor;
import com.tinqin.project.operation.HeroFightProcessor;
import com.tinqin.project.operation.HeroMovieProcessor;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HeroController {
    private final HeroAppearanceProcessor heroAppearanceProcessor;
    private final HeroBiographyProcessor heroBiographyProcessor;

    private final HeroFightProcessor heroFightProcessor;
    private final HeroMovieProcessor heroMovieProcessor;

    public HeroController(HeroAppearanceProcessor heroAppearanceProcessor, HeroBiographyProcessor heroBiographyProcessor, HeroFightProcessor heroFightProcessor, HeroMovieProcessor heroMovieProcessor) {
        this.heroAppearanceProcessor = heroAppearanceProcessor;
        this.heroBiographyProcessor = heroBiographyProcessor;
        this.heroFightProcessor = heroFightProcessor;
        this.heroMovieProcessor = heroMovieProcessor;
    }

    @PostMapping("/getAppearance")
    public ResponseEntity<?> getAppearance(@RequestBody final HeroAppearanceRequest heroAppearanceRequest)
    {
        Either<Error, HeroAppearanceResponse> response = heroAppearanceProcessor.process(heroAppearanceRequest);
        if (response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }

    @PostMapping("/getBiography")
    public ResponseEntity<?> getBiography(@RequestBody final HeroBiographyRequest heroBiographyRequest)
    {
        Either<Error, HeroBiographyResponse> response = heroBiographyProcessor.process(heroBiographyRequest);
        if (response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }

    @PostMapping("/getFightResult")
    public ResponseEntity<?> getFightResult(@RequestBody final HeroFightRequest heroFightRequest)
    {
        Either<Error, HeroFightResponse> response = heroFightProcessor.process(heroFightRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }

    @PostMapping("/getHeroMovies")
    public ResponseEntity<?> getMovies(@RequestBody final HeroMovieRequest heroMovieRequest)
    {
        Either<Error, HeroMovieResponse> response = heroMovieProcessor.process(heroMovieRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }


}
