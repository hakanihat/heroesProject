package com.tinqin.project.models.hero_biography.db;

import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class DBHeroBiographyRequest {
    private Long heroId;
}
