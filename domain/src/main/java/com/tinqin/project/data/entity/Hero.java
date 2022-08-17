package com.tinqin.project.data.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Heroes")
@Getter
@Setter
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHero;

    private String heroName;

    private String heroAge;

    private String heroGender;

    private String alignment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAttribute", referencedColumnName = "idAttribute")
    private HeroAttribute heroAttribute;

    @ManyToOne
    @JoinColumn(name = "idHeroTypes")
    private HeroType heroType;

    @OneToMany(mappedBy = "hero")
    private Set<MoviesOfTheHero>  heroMovies= new HashSet<>();

    public Hero() {
    }


}
