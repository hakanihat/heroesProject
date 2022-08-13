package com.tinqin.project.api.models.hero_movie;

import com.tinqin.project.api.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HeroMovieRequest implements OperationInput {
    private String heroName;
}
