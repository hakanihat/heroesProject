package com.tinqin.project.models.hero_fight;


import com.tinqin.project.generics.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class HeroFightResponse implements OperationResult {
    private String winnerName;
    private String heroPoints;
}
