package com.tinqin.project.processor;

import com.tinqin.project.data.entity.Hero;
import com.tinqin.project.data.repository.HeroRepository;
import com.tinqin.project.error.general.GeneralServerError;
import com.tinqin.project.error.hero.NoSuchHeroError;
import com.tinqin.project.exception.hero.HeroNotFoundException;
import com.tinqin.project.feign.HeroClient;
import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero_appearance.HeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.HeroAppearanceResponse;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceResponse;
import com.tinqin.project.operation.HeroAppearanceProcessor;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

@Service
public class HeroAppearanceProcessorCore implements HeroAppearanceProcessor {

    private final HeroRepository heroRepository;
    private final HeroClient heroClient;

    public HeroAppearanceProcessorCore(HeroRepository heroRepository, HeroClient heroClient) {
        this.heroRepository = heroRepository;
        this.heroClient = heroClient;
    }

    @Override
    public Either<Error, HeroAppearanceResponse> process(final HeroAppearanceRequest input) {
        return Try.of(()->{
            final Hero hero = heroRepository.findById(input.getHeroId())
                    .orElseThrow(HeroNotFoundException::new);
            final FeignHeroAppearanceResponse appearanceResponse = heroClient.getHeroAppearance(
                    FeignHeroAppearanceRequest.builder().heroId(hero.getIdHero()).build()
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
