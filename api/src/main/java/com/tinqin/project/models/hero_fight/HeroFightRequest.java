package com.tinqin.project.models.hero_fight;

import com.tinqin.project.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class HeroFightRequest implements OperationInput {
    private Long firstHeroId;
    private Long secondHeroId;

}
