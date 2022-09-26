package com.tinqin.project.models.hero_fight.db;

import com.tinqin.project.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class DBHeroFightRequest implements OperationInput {
    private Long firstHeroId;
    private Long secondHeroId;
}
