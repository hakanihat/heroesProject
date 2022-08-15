package com.tinqin.project.processor;

import com.tinqin.project.data.entity.Hero;
import com.tinqin.project.data.repository.HeroRepository;
import com.tinqin.project.error.general.GeneralServerError;
import com.tinqin.project.error.hero.NoSuchHeroError;
import com.tinqin.project.exception.hero.HeroNotFoundException;
import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero.HeroRequest;
import com.tinqin.project.models.hero.HeroResponse;
import com.tinqin.project.operation.HeroProcessor;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;

public class HeroProcessorCore implements HeroProcessor {

    private final ConversionService conversionService;
    private final HeroRepository heroRepository;

    public HeroProcessorCore(ConversionService conversionService, HeroRepository heroRepository) {
        this.conversionService = conversionService;
        this.heroRepository = heroRepository;
    }

    @Override
    public Either<Error, HeroResponse> process(HeroRequest input) {
        return Try.of(()-> {
            final Hero hero = heroRepository.findById(input.getHeroId())
                    .orElseThrow(HeroNotFoundException::new);
            return conversionService.convert(hero, HeroResponse.class);
        }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof HeroNotFoundException) {
                        return new NoSuchHeroError();
                    }
                    return new GeneralServerError();
                });


    }
}
