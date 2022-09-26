package com.tinqin.project.models.hero_appearance.feign;

import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class FeignHeroAppearanceRequest {
    private Long heroId;
}
