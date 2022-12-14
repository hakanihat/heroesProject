package com.tinqin.project.models.hero_movie;

import com.tinqin.project.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class HeroMovieRequest implements OperationInput {
    private String heroId;
}
