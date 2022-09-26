package com.tinqin.project.models.hero_fight;


import com.tinqin.project.generics.OperationResult;
import lombok.*;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString

public class HeroFightResponse implements OperationResult {
    private String winnerName;
    private String pointDifference;
}
