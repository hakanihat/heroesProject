package com.tinqin.project.models.hero_movie.db;

import com.tinqin.project.generics.OperationResult;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DBHeroMovieResponse implements OperationResult {
    private String movieName;
    private String releaseDate;
}
