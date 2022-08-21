package com.tinqin.project.models.hero.db;

import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DBHeroRequest {
    private Long heroId;
}
