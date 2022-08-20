package com.tinqin.project.models.hero_appearance.db;

import com.tinqin.project.models.DBHeroRequest;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DBHeroAppearanceRequest implements DBHeroRequest {
    private Long heroId;

}
