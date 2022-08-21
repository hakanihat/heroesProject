package com.tinqin.project.processor;

import com.tinqin.project.error.general.GeneralServerError;
import com.tinqin.project.error.hero.NoSuchHeroError;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero_biography.HeroBiographyResponse;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyResponse;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyResponse;
import com.tinqin.project.models.hero_fight.HeroFightRequest;
import com.tinqin.project.models.hero_fight.HeroFightResponse;
import com.tinqin.project.models.hero_fight.db.DBHeroFightRequest;
import com.tinqin.project.models.hero_fight.db.DBHeroFightResponse;
import com.tinqin.project.operation.HeroFightProcessor;
import feign.FeignException;
import feign.RetryableException;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

@Service
public class HeroFightProcessorCore implements HeroFightProcessor {
    private final HeroCrudClient heroCrudClient;

    public HeroFightProcessorCore(HeroCrudClient heroCrudClient) {
        this.heroCrudClient = heroCrudClient;
    }

    @Override
    public Either<Error, HeroFightResponse> process(HeroFightRequest input) {
        return Try.of(()->{
                final DBHeroFightResponse  dbHeroFightResponse = heroCrudClient.getFightResult(
                        DBHeroFightRequest.builder()
                                .firstHeroId(input.getFirstHeroId())
                                .secondHeroId(input.getSecondHeroId())
                                .build()
                );
                    return HeroFightResponse.builder()
                            .winnerName(dbHeroFightResponse.getWinnerName())
                            .pointDifference(dbHeroFightResponse.getPointDifference())
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
