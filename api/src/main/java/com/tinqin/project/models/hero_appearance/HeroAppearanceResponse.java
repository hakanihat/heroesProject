package com.tinqin.project.models.hero_appearance;

import com.tinqin.project.generics.OperationResult;
import lombok.*;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class HeroAppearanceResponse implements OperationResult {
    private String race;
    private String eyeColor;
    private String hairColor;
    private String heightInCm;
    private String WeightInKg;

}
