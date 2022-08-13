package com.tinqin.project.api.models.create;

import com.tinqin.project.api.generics.OperationInput;

public class HeroCreateRequest implements OperationInput {
    private String heroName;
    private String heroAge;
    private String heroGender;
    private String alignment;
    private Integer idHeroAttributes;
    private Integer idHeroTypes;
}
