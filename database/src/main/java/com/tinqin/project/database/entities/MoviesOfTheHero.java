package com.tinqin.project.database.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MoviesOfTheHeroes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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
}
