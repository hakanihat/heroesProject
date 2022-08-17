package com.tinqin.project.rest;

import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero_appearance.HeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.HeroAppearanceResponse;
import com.tinqin.project.operation.HeroAppearanceProcessor;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HeroController {
    private final HeroAppearanceProcessor heroAppearanceProcessor;

    public HeroController(HeroAppearanceProcessor heroAppearanceProcessor) {
        this.heroAppearanceProcessor = heroAppearanceProcessor;
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


}
