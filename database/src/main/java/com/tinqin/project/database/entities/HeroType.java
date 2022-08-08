package com.tinqin.project.database.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="HeroTypes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class HeroType {
    @Id
    @GeneratedValue
    private Long idHeroTypes;

    private String typeName;

    @OneToMany(mappedBy = "heroType")
    private Set<Hero> heroes;
}
