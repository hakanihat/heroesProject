package com.tinqin.project.models.hero_appearance.feign;

import com.tinqin.project.models.DBHeroResponse;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class FeignHeroAppearanceResponse implements DBHeroResponse {
    private String race;
    private String eyeColor;
    private String hairColor;
    private String heightInCm;
    private String WeightInKg;

}
