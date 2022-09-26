package com.tinqin.project;

import com.tinqin.project.feign.HeroClient;
import com.tinqin.project.feign.HeroCrudClient;
import com.tinqin.project.models.hero_appearance.HeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.HeroAppearanceResponse;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.db.DBHeroAppearanceResponse;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.feign.FeignHeroAppearanceResponse;
import com.tinqin.project.models.hero_biography.HeroBiographyRequest;
import com.tinqin.project.processor.HeroAppearanceProcessorCore;
import com.tinqin.project.processor.HeroBiographyProcessorCore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class HeroAppearanceProcessorCoreTest {
    @Mock
    private HeroClient heroClient;

    @Mock
    private HeroCrudClient heroCrudClient;

    @InjectMocks
    private HeroAppearanceProcessorCore heroAppearanceProcessorCore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcess(){

        when(heroCrudClient.checkHero(DBHeroAppearanceRequest.builder()
                .heroId(1L)
                .build()))
                    .thenReturn(DBHeroAppearanceResponse.builder()
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

        when(heroClient.getHeroAppearance(FeignHeroAppearanceRequest.builder()
                .heroId(1L)
                .build()))
                .thenReturn(FeignHeroAppearanceResponse.builder()
                        .race("Human")
                        .heightInCm("203 cm")
                        .WeightInKg("441 kg")
                        .eyeColor("Yellow")
                        .hairColor("No Hair")
                        .build());


        DBHeroAppearanceResponse db = DBHeroAppearanceResponse.builder()
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
                .build();



       FeignHeroAppearanceResponse f = FeignHeroAppearanceResponse.builder()
               .race("Human")
               .heightInCm("203 cm")
               .WeightInKg("441 kg")
               .eyeColor("Yellow")
               .hairColor("No Hair")
               .build();

       HeroAppearanceResponse heroAppearanceResponse = HeroAppearanceResponse.builder()
               .race("Human")
               .heightInCm("203 cm")
               .WeightInKg("441 kg")
               .eyeColor("Yellow")
               .hairColor("No Hair")
                       .build();

        Assertions.assertEquals(db,heroCrudClient.checkHero(new DBHeroAppearanceRequest(1L)));
        Assertions.assertNotNull(heroAppearanceProcessorCore.process(new HeroAppearanceRequest(1L)));
        Assertions.assertEquals(f,heroClient.getHeroAppearance(new FeignHeroAppearanceRequest(1L)));
        Assertions.assertEquals(heroAppearanceResponse,heroAppearanceProcessorCore.process(new HeroAppearanceRequest(1L)).get());

    }


}
