package com.tinqin.project.models.hero_appearance.feign;

import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class FeignHeroAppearanceResponse {
    private String race;
    private String eyeColor;
    private String hairColor;
    private String heightInCm;
    private String WeightInKg;

}
