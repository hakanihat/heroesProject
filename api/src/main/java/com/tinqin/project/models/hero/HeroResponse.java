package com.tinqin.project.models.hero;

import com.tinqin.project.generics.OperationResult;
import lombok.*;


@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class HeroResponse implements OperationResult {
private String heroName;
private String intelligence;
private String strength;
private String speed;
private String durability;
private String combat;
private String power;//ll
}
