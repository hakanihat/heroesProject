package com.tinqin.project.models.hero_biography.feign;

import com.tinqin.project.models.DBHeroResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class FeignHeroBiographyResponse implements DBHeroResponse {
    private String fullName;
    private String alterEgos;
    private String placeOfBirth;
    private String firstAppearance;
    private String publisher;
}
