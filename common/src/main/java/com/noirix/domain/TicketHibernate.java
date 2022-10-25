package com.noirix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    @JsonBackReference
    private MovieHibernate movie;

    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonBackReference
    private SessionHibernate session;

    @Column(name = "date_of_purchase")
    private Timestamp dateOfPurchase;

    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceHibernate place;


}
