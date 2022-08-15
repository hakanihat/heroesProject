package com.tinqin.project.processor;

import com.tinqin.project.data.repository.HeroRepository;
import com.tinqin.project.feign.HeroClient;
import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero_appearance.HeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.HeroAppearanceResponse;
import com.tinqin.project.operation.HeroAppearanceProcessor;
import io.vavr.control.Either;

public class HeroAppearanceProcessorCore implements HeroAppearanceProcessor {

    private final HeroRepository heroRepository;
    private final HeroClient heroClient;

    public HeroAppearanceProcessorCore(HeroRepository heroRepository, HeroClient heroClient) {
        this.heroRepository = heroRepository;
        this.heroClient = heroClient;
    }

    @Override
    public Either<Error, HeroAppearanceResponse> process(HeroAppearanceRequest input) {
        return null;
    }
}
