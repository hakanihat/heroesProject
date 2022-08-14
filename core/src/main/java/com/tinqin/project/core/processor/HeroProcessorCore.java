package com.tinqin.project.core.processor;

import com.tinqin.project.api.generics.Error;
import com.tinqin.project.api.models.hero.HeroRequest;
import com.tinqin.project.api.models.hero.HeroResponse;
import com.tinqin.project.api.operation.HeroProcessor;
import io.vavr.control.Either;
import org.springframework.core.convert.ConversionService;

public class HeroProcessorCore implements HeroProcessor {

    private final ConversionService conversionService;
    private final HeroRepository heroRepository;

    @Override
    public Either<Error, HeroResponse> process(HeroRequest input) {
        return null;
    }
}
