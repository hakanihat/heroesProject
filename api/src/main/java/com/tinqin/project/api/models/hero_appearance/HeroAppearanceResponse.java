package com.tinqin.project.api.models.hero_appearance;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class HeroAppearanceResponse {
    private String heroRace;
    private String height;
    private String weight;
    private String eyeColor;
    private String hairColor;
}
