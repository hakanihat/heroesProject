package com.tinqin.project.models.hero_fight.db;

import com.tinqin.project.generics.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
public class DBHeroFightResponse implements OperationResult {
    private String winnerName;
    private String pointDifference;
}
