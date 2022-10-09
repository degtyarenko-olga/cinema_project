package com.noirix.domain.hibernate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ticket")
@EqualsAndHashCode(exclude = {
        "movie,session,place"
})
@ToString(exclude = {
        "movie,session,place"
})
public class TicketHibernate {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
//    @JsonBackReference
    @JsonManagedReference
    private MovieHibernate movie;

    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonManagedReference
    private SessionHibernate session;

//    @ManyToOne
//    @Column(name = "hall_id")
//    private HallHibernate hall;

    @Column(name = "date_of_purchase")
    private Timestamp dateOfPurchase;

    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonManagedReference
    private PlaceHibernate place;


}
