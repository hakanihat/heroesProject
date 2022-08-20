package com.tinqin.project.processor;

import com.tinqin.project.error.general.GeneralServerError;
import com.tinqin.project.error.hero.NoSuchHeroError;
import com.tinqin.project.feign.HeroClient;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceRequest;
import com.tinqin.project.models.hero_biography.HeroBiographyRequest;
import com.tinqin.project.models.hero_biography.HeroBiographyResponse;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyResponse;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyResponse;
import com.tinqin.project.operation.HeroBiographyProcessor;
import feign.FeignException;
import feign.RetryableException;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

@Service
public class HeroBiographyProcessorCore implements HeroBiographyProcessor {
    private final HeroCrudClient heroCrudClient;
    private final HeroClient heroClient;

    public HeroBiographyProcessorCore(HeroCrudClient heroCrudClient, HeroClient heroClient) {
        this.heroCrudClient = heroCrudClient;
        this.heroClient = heroClient;
    }

    @Override
    public Either<Error, HeroBiographyResponse> process(final HeroBiographyRequest input) {
        return Try.of(()->{
            final DBHeroBiographyResponse dbHeroBiographyResponse =heroCrudClient.checkHeroAndAlignment(
                    DBHeroBiographyRequest.builder().heroId(input.getHeroId()).build());
            final FeignHeroBiographyResponse biographyResponse = heroClient.getHeroBiography(
                    FeignHeroBiographyRequest.builder().heroId(dbHeroBiographyResponse.getHeroId()).build()
            );
            return HeroBiographyResponse.builder()
                    .fullName(biographyResponse.getFullName())
                    .alignment(dbHeroBiographyResponse.getAlignment())
                    .alterEgos(biographyResponse.getAlterEgos())
                    .firstAppearance(biographyResponse.getFirstAppearance())
                    .placeOfBirth(biographyResponse.getPlaceOfBirth())
                    .publisher(biographyResponse.getPublisher())
                    .build();
        }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof FeignException)
                        return new NoSuchHeroError();
                    if(throwable instanceof RetryableException)
                        return new NoSuchHeroError();
                    return new GeneralServerError();
                });
    }
}
