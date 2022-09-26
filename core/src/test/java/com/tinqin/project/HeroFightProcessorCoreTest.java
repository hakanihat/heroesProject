package com.tinqin.project;

import com.tinqin.project.feign.HeroClient;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.models.hero_biography.HeroBiographyRequest;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyResponse;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyResponse;
import com.tinqin.project.models.hero_fight.HeroFightRequest;
import com.tinqin.project.models.hero_fight.HeroFightResponse;
import com.tinqin.project.models.hero_fight.db.DBHeroFightRequest;
import com.tinqin.project.models.hero_fight.db.DBHeroFightResponse;
import com.tinqin.project.processor.HeroBiographyProcessorCore;
import com.tinqin.project.processor.HeroFightProcessorCore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class HeroFightProcessorCoreTest {

    @Mock
    private HeroCrudClient heroCrudClient;

    @InjectMocks
    private HeroFightProcessorCore heroFightProcessorCore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcess(){

        when(heroCrudClient.getFightResult(DBHeroFightRequest.builder()
                        .firstHeroId(1L)
                        .secondHeroId(687L)
                        .build()))
                .thenReturn(DBHeroFightResponse.builder()
                        .winnerName("Venom")
                        .pointDifference("128")
                        .build());




        DBHeroFightResponse db = DBHeroFightResponse.builder()
                .winnerName("Venom")
                .pointDifference("128")
                .build();

        HeroFightResponse heroFightResponse = HeroFightResponse.builder()
                        .winnerName("Venom")
                                .pointDifference("128")
                                        .build();




        Assertions.assertEquals(db,heroCrudClient.getFightResult(new DBHeroFightRequest(1L,687L)));
        Assertions.assertNotNull(heroFightProcessorCore.process(new HeroFightRequest(1L,687L)));
        Assertions.assertEquals(heroFightResponse,heroFightProcessorCore.process(new HeroFightRequest(1L,687L)).get());


    }
}
