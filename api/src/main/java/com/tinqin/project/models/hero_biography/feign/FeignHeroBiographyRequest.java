package com.tinqin.project.models.hero_biography.feign;

import com.tinqin.project.models.DBHeroRequest;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeignHeroBiographyRequest implements DBHeroRequest {
    private Long heroId;
}
