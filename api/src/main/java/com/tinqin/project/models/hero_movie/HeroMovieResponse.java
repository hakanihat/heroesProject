package com.tinqin.project.models.hero_movie;

import com.tinqin.project.generics.OperationResult;
import com.tinqin.project.models.hero_fight.db.DBHeroFightResponse;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
public class HeroMovieResponse implements OperationResult {
    private List<DBHeroMovieResponse> movie;
}
