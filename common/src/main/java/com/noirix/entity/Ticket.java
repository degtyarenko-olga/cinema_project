package com.noirix.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "ticket")
@EqualsAndHashCode(exclude = {
        "movie,session,place,user"
})
@ToString(exclude = {
        "movie,session,place,user"
})
public class Ticket {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonManagedReference
    private Session session;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    @JsonManagedReference
    private Place place;

    @Column(name = "date_of_purchase")
    private Timestamp dateOfPurchase;

}
