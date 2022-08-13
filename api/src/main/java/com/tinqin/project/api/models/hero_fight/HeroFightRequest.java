package com.tinqin.project.api.models.hero_fight;

import com.tinqin.project.api.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeroFightRequest implements OperationInput {
    private Long firstHeroId;
    private Long secondHeroId;

}
