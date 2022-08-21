package com.tinqin.project.processor;

import com.tinqin.project.error.general.GeneralServerError;
import com.tinqin.project.error.hero.NoSuchHeroError;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.generics.Error;
import com.tinqin.project.models.hero_fight.HeroFightResponse;
import com.tinqin.project.models.hero_fight.db.DBHeroFightRequest;
import com.tinqin.project.models.hero_fight.db.DBHeroFightResponse;
import com.tinqin.project.models.hero_movie.HeroMovieRequest;
import com.tinqin.project.models.hero_movie.HeroMovieResponse;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieRequest;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieResponse;
import com.tinqin.project.operation.HeroMovieProcessor;
import feign.FeignException;
import feign.RetryableException;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroMovieProcessorCore implements HeroMovieProcessor {

    private final HeroCrudClient heroCrudClient;

    public HeroMovieProcessorCore(HeroCrudClient heroCrudClient) {
        this.heroCrudClient = heroCrudClient;
    }

    @Override
    public Either<Error, HeroMovieResponse> process(HeroMovieRequest input) {
        return Try.of(()->{

            final List<DBHeroMovieResponse> dbHeroMovieResponse = heroCrudClient.getHeroMovies(
                    DBHeroMovieRequest.builder().heroId(input.getHeroId()).build()
            );

                    return HeroMovieResponse.builder()
                            .movie(dbHeroMovieResponse)
                            .build();
                }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof FeignException)
                        return new NoSuchHeroError();
                    if(throwable instanceof RetryableException)
                        return new NoSuchHeroError();
                    return new GeneralServerError();
                });
    }
}
