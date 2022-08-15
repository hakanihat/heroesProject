package com.tinqin.project.models.hero_appearance;

import com.tinqin.project.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HeroAppearanceRequest implements OperationInput {
    private Long heroId;
}
