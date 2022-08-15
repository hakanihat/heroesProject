package com.tinqin.project.data.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "HeroAttributes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class HeroAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAttribute;

    private Integer intelligence;

    private Integer strength;

    private Integer speed;

    private Integer durability;

    private Integer combat ;

    private Integer power;

    @OneToOne(mappedBy = "heroAttribute")
    private Hero hero;
}
