package com.noirix.domain.hibernate;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "hall")
public class HallHibernate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name_hall")
    private String nameHall;

    @ManyToMany
    @JoinTable(name = "l_place_hall",
            joinColumns = @JoinColumn(name = "hall_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    @JsonIgnoreProperties("hall")
    private Set<PlaceHibernate> place;

}
