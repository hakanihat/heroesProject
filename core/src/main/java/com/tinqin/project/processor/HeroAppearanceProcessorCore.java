package com.tinqin.project.processor;


import com.tinqin.project.error.general.GeneralServerError;
import com.tinqin.project.error.hero.NoSuchHeroError;
import com.tinqin.project.exception.hero.HeroNotFoundException;
import com.tinqin.project.feign.HeroClient;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero_appearance.HeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.HeroAppearanceResponse;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceResponse;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceResponse;
import com.tinqin.project.operation.HeroAppearanceProcessor;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeroAppearanceProcessorCore implements HeroAppearanceProcessor {

   // private final HeroRepository heroRepository;
    private final HeroCrudClient heroCrudClient;
    private final HeroClient heroClient;

    public HeroAppearanceProcessorCore(HeroCrudClient heroCrudClient, HeroClient heroClient) {
        this.heroCrudClient = heroCrudClient;
        this.heroClient = heroClient;
    }

    @Override
    public Either<Error, HeroAppearanceResponse> process(final HeroAppearanceRequest input) {
        return Try.of(()->{
            final DBHeroAppearanceResponse dbHeroAppearanceResponse = heroCrudClient.checkHero(
                    DBHeroAppearanceRequest.builder().heroId(input.getHeroId()).build());
            final FeignHeroAppearanceResponse appearanceResponse = heroClient.getHeroAppearance(
                    FeignHeroAppearanceRequest.builder().heroId(dbHeroAppearanceResponse.getHeroId()).build()
            );

            return HeroAppearanceResponse.builder()
                    .race(appearanceResponse.getRace())
                    .eyeColor(appearanceResponse.getEyeColor())
                    .hairColor(appearanceResponse.getHairColor())
                    .heightInCm(appearanceResponse.getHeightInCm())
                    .WeightInKg(appearanceResponse.getWeightInKg())
                    .build();
        }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof HeroNotFoundException)
                        return new NoSuchHeroError();

                   return new GeneralServerError();
                });
    }
}
