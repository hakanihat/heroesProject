package com.tinqin.project.models.hero_biography.db;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
public class DBHeroBiographyResponse {
    private Long heroId;
    private String alignment;

}