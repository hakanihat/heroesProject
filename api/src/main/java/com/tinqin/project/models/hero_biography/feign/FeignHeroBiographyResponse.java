package com.tinqin.project.models.hero_biography.feign;

import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class FeignHeroBiographyResponse {
    private String fullName;
    private String alterEgos;
    private String placeOfBirth;
    private String firstAppearance;
    private String publisher;
}
