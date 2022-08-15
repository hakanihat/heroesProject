package com.tinqin.project.data.entity;


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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAttribute", referencedColumnName = "idAttribute")
    private HeroAttribute heroAttribute;

    @ManyToOne
    @JoinColumn(name = "idHeroTypes")
    private HeroType heroType;

    @OneToMany(mappedBy = "moviesOfTheHero")
    private Set<MoviesOfTheHero> moviesOfTheHeroes;



}
