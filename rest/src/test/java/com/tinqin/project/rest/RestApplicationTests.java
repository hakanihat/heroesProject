package com.tinqin.project.rest;

import com.tinqin.project.models.hero.HeroRequest;
import com.tinqin.project.models.hero.HeroResponse;
import com.tinqin.project.models.hero_appearance.HeroAppearanceRequest;
import com.tinqin.project.models.hero_appearance.HeroAppearanceResponse;
import com.tinqin.project.models.hero_biography.HeroBiographyRequest;
import com.tinqin.project.models.hero_biography.HeroBiographyResponse;
import com.tinqin.project.models.hero_fight.HeroFightRequest;
import com.tinqin.project.models.hero_fight.HeroFightResponse;
import com.tinqin.project.models.hero_movie.HeroMovieRequest;
import com.tinqin.project.models.hero_movie.HeroMovieResponse;
import com.tinqin.project.models.hero_movie.db.DBHeroMovieResponse;
import feign.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class RestApplicationTests {

    @Autowired
    private  HeroController heroController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAppearance() {
        ArrayList<String> hei = new ArrayList<>();
        ArrayList<String> wei = new ArrayList<>();
        hei.add("70.86");
        hei.add("180");
        wei.add("165.34");
        wei.add("75");
        HeroAppearanceRequest heroAppearanceRequest = HeroAppearanceRequest.builder()
                .heroId(1L)
                .build();

        HeroAppearanceResponse heroAppearanceResponse = HeroAppearanceResponse.builder()
                .race("Human")
                .heightInCm("203 cm")
                .WeightInKg("441 kg")
                .eyeColor("Yellow")
                .hairColor("No Hair")
                .build();

        ResponseEntity<HeroAppearanceResponse> response = ResponseEntity.status(HttpStatus.OK).body(heroAppearanceResponse);
        Assertions.assertEquals(response,heroController.getAppearance(heroAppearanceRequest));



    }

    @Test
    void testGetBiography(){
        HeroBiographyRequest heroBiographyRequest = HeroBiographyRequest.builder()
                .heroId(1L)
                .build();

        HeroBiographyResponse heroBiographyResponse = HeroBiographyResponse.builder()
                .fullName("Richard Milhouse Jones")
                .alterEgos("No alter egos found.")
                .firstAppearance("Hulk Vol 2 #2 (April, 2008) (as A-Bomb)")
                .publisher("Marvel Comics")
                .placeOfBirth("Scarsdale, Arizona")
                .alignment("good")
                .build();

        ResponseEntity<HeroBiographyResponse> response = ResponseEntity.ok(heroBiographyResponse);

        Assertions.assertEquals(response, heroController.getBiography(heroBiographyRequest));
    }

    @Test
    void testGetFightResult(){
        HeroFightRequest heroFightRequest = HeroFightRequest.builder()
                .firstHeroId(1L)
                .secondHeroId(687L)
                .build();

        HeroFightResponse heroFightResponse = HeroFightResponse.builder()
                .winnerName("Venom")
                .pointDifference("128")
                .build();

        ResponseEntity<HeroFightResponse> response = ResponseEntity.ok(heroFightResponse);

        Assertions.assertNotNull(heroController.getFightResult(heroFightRequest));
        Assertions.assertEquals(response, heroController.getFightResult(heroFightRequest));

    }

    @Test
    void testGetMovies(){

        DBHeroMovieResponse herMov = new DBHeroMovieResponse("Avengers: Infinity War","2018-04-23");
        DBHeroMovieResponse herMov2 = new DBHeroMovieResponse("Avengers: Endgame","2019-04-26");
        List<DBHeroMovieResponse> heroMovies = new ArrayList<>();
        heroMovies.add(herMov);
        heroMovies.add(herMov2);
        HeroMovieResponse heroMovieResponse1 = new HeroMovieResponse(heroMovies);
        HeroMovieRequest heroMovieRequest = HeroMovieRequest.builder()
                .heroId("1")
                .build();


        ResponseEntity<HeroMovieResponse> response = ResponseEntity.status(HttpStatus.OK)
                .body(heroMovieResponse1);

        Assertions.assertEquals(response,heroController.getMovies(heroMovieRequest));
        HeroMovieRequest fakeRequest = HeroMovieRequest.builder()
                .heroId("5")
                .build();

        Assertions.assertEquals(HttpStatus.NOT_FOUND, heroController.getMovies(fakeRequest).getStatusCode());

    }

    @Test
    void  testGetHeroStats(){

        HeroRequest heroRequest = HeroRequest.builder()
                .heroId(1L)
                .build();

        HeroResponse heroResponse = HeroResponse.builder()
                .heroName("A-Bomb")
                .intelligence("38")
                .power("24")
                .strength("100")
                .speed("17")
                .combat("64")
                .durability("80")
                .build();

        ResponseEntity<HeroResponse> response = ResponseEntity.ok(heroResponse);

        Assertions.assertNotNull(heroController.getHeroStats(heroRequest));
        Assertions.assertEquals(response, heroController.getHeroStats(heroRequest));

    }

}
