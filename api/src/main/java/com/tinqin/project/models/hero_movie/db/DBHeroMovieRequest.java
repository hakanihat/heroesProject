package com.tinqin.project.models.hero_movie.db;

import com.tinqin.project.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DBHeroMovieRequest implements OperationInput {
    private String heroId;
}
