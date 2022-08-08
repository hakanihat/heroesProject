package com.tinqin.project.database.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovie;

    private String movieName;

    private Date releaseDate;

    @OneToMany(mappedBy = "movie")
    private Set<Movie> movies;
}
