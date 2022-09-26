package com.tinqin.project;

import com.tinqin.project.feign.HeroClient;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.models.hero_appearance.HeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceResponse;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceResponse;
import com.tinqin.project.models.hero_biography.HeroBiographyRequest;
import com.tinqin.project.models.hero_biography.HeroBiographyResponse;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.db.DBHeroBiographyResponse;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyRequest;
import com.tinqin.project.models.hero_biography.feign.FeignHeroBiographyResponse;
import com.tinqin.project.models.hero_fight.HeroFightRequest;
import com.tinqin.project.processor.HeroAppearanceProcessorCore;
import com.tinqin.project.processor.HeroBiographyProcessorCore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class HeroBiographyProcessorCoreTest {
    @Mock
    private HeroClient heroClient;

    @Mock
    private HeroCrudClient heroCrudClient;

    @InjectMocks
    private HeroBiographyProcessorCore heroBiographyProcessorCore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcess(){

        when(heroCrudClient.checkHeroAndAlignment(DBHeroBiographyRequest.builder()
                .heroId(1L)
                .build()))
                .thenReturn(DBHeroBiographyResponse.builder()
                        .heroId(1L)
                        .alignment("good")
                        .build());

        when(heroClient.getHeroBiography(FeignHeroBiographyRequest.builder()
                .heroId(1L)
                .build()))
                .thenReturn(FeignHeroBiographyResponse.builder()
                        .fullName("Richard Milhouse Jones")
                        .alterEgos("No alter egos found.")
                        .firstAppearance("Hulk Vol 2 #2 (April, 2008) (as A-Bomb)")
                        .publisher("Marvel Comics")
                        .placeOfBirth("Scarsdale, Arizona")
                        .build());


        DBHeroBiographyResponse db = DBHeroBiographyResponse.builder()
                .heroId(1L)
                .alignment("good")
                .build();



        FeignHeroBiographyResponse f = FeignHeroBiographyResponse.builder()
                .fullName("Richard Milhouse Jones")
                .alterEgos("No alter egos found.")
                .firstAppearance("Hulk Vol 2 #2 (April, 2008) (as A-Bomb)")
                .publisher("Marvel Comics")
                .placeOfBirth("Scarsdale, Arizona")
                .build();

        HeroBiographyResponse heroBiographyResponse = HeroBiographyResponse.builder()
                .fullName("Richard Milhouse Jones")
                .alterEgos("No alter egos found.")
                .firstAppearance("Hulk Vol 2 #2 (April, 2008) (as A-Bomb)")
                .publisher("Marvel Comics")
                .placeOfBirth("Scarsdale, Arizona")
                .alignment("good")
                        .build();

        Assertions.assertEquals(db,heroCrudClient.checkHeroAndAlignment(new DBHeroBiographyRequest(1L)));
        Assertions.assertNotNull(heroBiographyProcessorCore.process(new HeroBiographyRequest(1L)));
        Assertions.assertEquals(f,heroClient.getHeroBiography(new FeignHeroBiographyRequest(1L)));
        Assertions.assertEquals(heroBiographyResponse,heroBiographyProcessorCore.process(new HeroBiographyRequest(1L)).get());


    }
}
