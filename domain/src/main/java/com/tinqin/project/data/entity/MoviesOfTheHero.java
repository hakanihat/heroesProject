package com.tinqin.project.data.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MoviesOfTheHeroes")
@Getter
@Setter

public class MoviesOfTheHero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMoviesOfTheHero;

    @ManyToOne
    @JoinColumn(name = "idHero")
    private Hero hero;

    @ManyToOne
    @JoinColumn(name="idMovie")
    private Movie movie;

    public MoviesOfTheHero() {
    }

}
