package com.tinqin.project.models.hero_biography.feign;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class FeignHeroBiographyResponse {
    private String fullName;
    private String alterEgos;
    private String placeOfBirth;
    private String firstAppearance;
    private String publisher;
}
