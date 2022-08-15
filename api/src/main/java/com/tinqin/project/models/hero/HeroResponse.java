package com.tinqin.project.models.hero;

import com.tinqin.project.generics.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class HeroResponse implements OperationResult {
private String heroName;
private String heroAge;
private String heroGender;
private String alignment;
private String heroType;
private Integer intelligence;
private Integer strength;
private Integer speed;
private Integer durability;
private Integer combat;
private Integer power;
}
