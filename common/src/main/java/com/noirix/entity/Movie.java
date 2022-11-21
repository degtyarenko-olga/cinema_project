package com.noirix.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "movie")
@EqualsAndHashCode(exclude = {
        "ticket"
})
@ToString(exclude = {
        "ticket"
})
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "genre")
    private String genre;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Column(name = "age_restrictions")
    private Integer ageRestrictions;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Ticket> ticket;

}
