package com.tinqin.project.converter;

import com.tinqin.project.data.entity.Hero;
import com.tinqin.project.models.hero.HeroResponse;
import org.springframework.core.convert.converter.Converter;

public class HeroToHeroResponseConverter implements Converter<Hero, HeroResponse> {
    @Override
    public HeroResponse convert(Hero source) {
        return HeroResponse.builder()
                .heroName(source.getHeroName())
                .heroAge(source.getHeroAge())
                .heroGender(source.getHeroGender())
                .alignment(source.getAlignment())
                .heroType(source.getHeroType().getTypeName())
                .intelligence(source.getHeroAttribute().getIntelligence())
                .strength(source.getHeroAttribute().getStrength())
                .speed(source.getHeroAttribute().getSpeed())
                .durability(source.getHeroAttribute().getDurability())
                .combat(source.getHeroAttribute().getCombat())
                .power(source.getHeroAttribute().getPower())
                .build();
    }
}
