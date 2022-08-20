package com.tinqin.project.models.hero_appearance.feign;

import com.tinqin.project.models.DBHeroRequest;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeignHeroAppearanceRequest implements DBHeroRequest {
    private Long heroId;
}
