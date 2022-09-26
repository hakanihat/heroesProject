package com.tinqin.project.models.hero_biography.db;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class DBHeroBiographyResponse {
    private Long heroId;
    private String alignment;

}
