package com.tinqin.project.models.hero_appearance.db;

import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DBHeroAppearanceRequest {
    private Long heroId;

}
