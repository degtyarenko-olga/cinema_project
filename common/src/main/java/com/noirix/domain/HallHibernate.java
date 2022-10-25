package com.noirix.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Cacheable("hall")
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
