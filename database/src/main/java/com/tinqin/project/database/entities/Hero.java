package com.tinqin.project.database.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Heroes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHero;

    private String heroName;

    private String heroAge;

    private String heroGender;

    private String alignment;

    @ManyToOne
    @JoinColumn(name = "idAttribute" )
    private HeroAttribute heroAttribute;

    @ManyToOne
    @JoinColumn(name = "idHeroTypes")
    private HeroType heroType;

    @OneToMany(mappedBy = "moviesOfTheHero")
    private Set<MoviesOfTheHero> moviesOfTheHeroes;



}
