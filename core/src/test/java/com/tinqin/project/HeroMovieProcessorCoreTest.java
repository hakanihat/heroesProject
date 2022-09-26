package com.tinqin.project;

import com.tinqin.project.feign.HeroClient;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.models.hero_fight.HeroFightRequest;
import com.tinqin.project.models.hero_fight.HeroFightResponse;
import com.tinqin.project.models.hero_fight.db.DBHeroFightRequest;
import com.tinqin.project.models.hero_fight.db.DBHeroFightResponse;
import com.tinqin.project.models.hero_movie.HeroMovieRequest;
import com.tinqin.project.models.hero_movie.HeroMovieResponse;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieRequest;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieResponse;
import com.tinqin.project.processor.HeroBiographyProcessorCore;
import com.tinqin.project.processor.HeroMovieProcessorCore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class HeroMovieProcessorCoreTest {

    @Mock
    private HeroCrudClient heroCrudClient;

    @InjectMocks
    private HeroMovieProcessorCore heroMovieProcessorCore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcess(){

        DBHeroMovieResponse dbHeroMovieResponse1= DBHeroMovieResponse.builder()
                .movieName("Avengers: Infinity War")
                .releaseDate("2018-04-23")
                .build();

        DBHeroMovieResponse dbHeroMovieResponse2= DBHeroMovieResponse.builder()
                .movieName("Avengers: Endgame")
                .releaseDate("2019-04-26")
                .build();

        List<DBHeroMovieResponse> responseList = new ArrayList<>();
        responseList.add(dbHeroMovieResponse1);
        responseList.add(dbHeroMovieResponse2);

        when(heroCrudClient.getHeroMovies(DBHeroMovieRequest.builder()
                .heroId("1")
                .build()))
                .thenReturn(responseList);


        HeroMovieResponse heroMovieResponse = HeroMovieResponse.builder()
                        .movie(responseList)
                                .build();


        Assertions.assertNotNull(heroMovieProcessorCore.process(new HeroMovieRequest("1")));
        Assertions.assertEquals(heroMovieResponse,heroMovieProcessorCore.process(new HeroMovieRequest("1")).get());


    }
}
