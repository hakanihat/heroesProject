package com.tinqin.project.models.hero_appearance;

import com.tinqin.project.generics.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class HeroAppearanceResponse implements OperationResult {
    private String heroRace;
    private String height;
    private String weight;
    private String eyeColor;
    private String hairColor;
}
