package com.tinqin.project.models.hero_biography.feign;

import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class FeignHeroBiographyRequest {
    private Long heroId;
}
