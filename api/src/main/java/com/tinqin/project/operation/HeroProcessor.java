package com.tinqin.project.operation;

import com.tinqin.project.generics.OperationProcessor;
import com.tinqin.project.models.hero.HeroRequest;
import com.tinqin.project.models.hero.HeroResponse;

public interface HeroProcessor extends OperationProcessor<HeroRequest, HeroResponse> {
}
