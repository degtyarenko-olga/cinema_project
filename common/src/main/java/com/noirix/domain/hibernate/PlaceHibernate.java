package com.noirix.domain.hibernate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "place")
@EqualsAndHashCode(exclude = {
        "hall"
})
@ToString(exclude = {
        "hall"
})
public class PlaceHibernate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "place")
    private int place;

    @Column(name = "row")
    private int row;

    @Column(name = "is_available")
    private boolean isAvailable;

    @ManyToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("place")
    private Set<HallHibernate> hall;

    @Column(name = "price")
    private double price;


}
