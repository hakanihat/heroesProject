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
private String intelligence;
private String strength;
private String speed;
private String durability;
private String combat;
private String power;//ll
}
