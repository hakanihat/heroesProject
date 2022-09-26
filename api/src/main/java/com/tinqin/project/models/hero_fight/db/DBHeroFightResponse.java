package com.tinqin.project.models.hero_fight.db;

import com.tinqin.project.generics.OperationResult;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class DBHeroFightResponse implements OperationResult {
    private String winnerName;
    private String pointDifference;
}
