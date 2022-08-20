package com.tinqin.project.models.hero_appearance.db;

import com.tinqin.project.models.DBHeroResponse;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)

public class DBHeroAppearanceResponse implements DBHeroResponse {
    private Long heroId;

    private String heroName;

    private String heroAge;

    private String heroGender;

    private String alignment;

    private String intelligence;

    private String power;

    private String strength;

    private String speed;

    private String combat;

    private String durability;

    private String heroType;

}
