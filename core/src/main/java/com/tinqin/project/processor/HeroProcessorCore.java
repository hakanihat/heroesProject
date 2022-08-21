package com.tinqin.project.processor;


import com.tinqin.project.error.general.GeneralServerError;
import com.tinqin.project.error.hero.NoSuchHeroError;
import com.tinqin.project.exception.hero.HeroNotFoundException;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero.HeroRequest;
import com.tinqin.project.models.hero.HeroResponse;
import com.tinqin.project.models.hero.db.DBHeroRequest;
import com.tinqin.project.models.hero.db.DBHeroResponse;
import com.tinqin.project.operation.HeroProcessor;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;


@Service

public class HeroProcessorCore implements HeroProcessor {

    private final HeroCrudClient heroCrudClient;

    public HeroProcessorCore(HeroCrudClient heroCrudClient) {
        this.heroCrudClient = heroCrudClient;

    }

    @Override
    public Either<Error, HeroResponse> process(HeroRequest input) {
        return Try.of(()-> {
            final DBHeroResponse dbHeroResponse= heroCrudClient.findHero(
                            DBHeroRequest.builder().heroId(input.getHeroId()).build()
                    );
            return HeroResponse.builder()
                    .heroName(dbHeroResponse.getHeroName())
                    .power(dbHeroResponse.getPower())
                    .combat(dbHeroResponse.getCombat())
                    .durability(dbHeroResponse.getDurability())
                    .speed(dbHeroResponse.getSpeed())
                    .strength(dbHeroResponse.getStrength())
                    .intelligence(dbHeroResponse.getIntelligence())
                    .build();

        }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof HeroNotFoundException) {
                        return new NoSuchHeroError();
                    }
                    return new GeneralServerError();
                });


    }
}
