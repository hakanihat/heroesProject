package com.tinqin.project.models.hero_biography.db;

import com.tinqin.project.models.DBHeroRequest;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DBHeroBiographyRequest implements DBHeroRequest {
    private Long heroId;
}
