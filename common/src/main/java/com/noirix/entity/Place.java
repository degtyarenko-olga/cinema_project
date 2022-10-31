package com.noirix.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
public class Place {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "place")
    private int place;

    @Column(name = "row")
    private int row;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @ManyToMany(mappedBy = "place", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("place")
    private Set<Hall> hall;

    @Column(name = "price")
    private Double price;

}
