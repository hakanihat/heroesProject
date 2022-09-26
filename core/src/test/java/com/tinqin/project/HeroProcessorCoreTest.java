package com.tinqin.project;

import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.models.hero.HeroRequest;
import com.tinqin.project.models.hero.HeroResponse;
import com.tinqin.project.models.hero.db.DBHeroRequest;
import com.tinqin.project.models.hero.db.DBHeroResponse;
import com.tinqin.project.models.hero_movie.HeroMovieRequest;
import com.tinqin.project.models.hero_movie.HeroMovieResponse;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieRequest;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieResponse;
import com.tinqin.project.processor.HeroMovieProcessorCore;
import com.tinqin.project.processor.HeroProcessorCore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class HeroProcessorCoreTest {

    @Mock
    private HeroCrudClient heroCrudClient;

    @InjectMocks
    private HeroProcessorCore heroProcessorCore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcess(){

        when(heroCrudClient.findHero(DBHeroRequest.builder()
                        .heroId(1L)
                .build()))
                .thenReturn(DBHeroResponse.builder()
                        .heroId(1L)
                        .heroName("A-Bomb")
                        .heroAge("unknown")
                        .heroGender("male")
                        .alignment("good")
                        .intelligence("38")
                        .power("24")
                        .strength("100")
                        .speed("17")
                        .combat("64")
                        .durability("80")
                        .heroType("melee")
                        .build());


        HeroResponse heroResponse = HeroResponse.builder()
                .heroName("A-Bomb")
                .intelligence("38")
                .power("24")
                .strength("100")
                .speed("17")
                .combat("64")
                .durability("80")
                        .build();


        Assertions.assertNotNull(heroProcessorCore.process(new HeroRequest(1L)));
        Assertions.assertEquals(heroResponse,heroProcessorCore.process(new HeroRequest(1L)).get());


    }
}
