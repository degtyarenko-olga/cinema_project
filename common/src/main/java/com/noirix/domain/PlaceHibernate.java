package com.noirix.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Cacheable("place")
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
    private Boolean isAvailable;

    @ManyToMany(mappedBy = "place", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("place")
    private Set<HallHibernate> hall;

//    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private Set<TicketHibernate> ticket;

    @Column(name = "price")
    private Double price;



}
