package com.tinqin.project.api.models.hero_appearance;

import com.tinqin.project.api.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HeroAppearanceRequest implements OperationInput {
    private Long heroId;
}
