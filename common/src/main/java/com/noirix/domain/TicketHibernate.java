package com.noirix.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

@Data
@Entity
@Table(name = "ticket")
@EqualsAndHashCode(exclude = {
        "movie,session,place,user"
})
@ToString(exclude = {
        "movie,session,place,user"
})
public class TicketHibernate {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private UsersHibernate user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private MovieHibernate movie;

    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonManagedReference
    private SessionHibernate session;


    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name = "place_id")
    @JsonManagedReference
    private PlaceHibernate place;

    @Column(name = "date_of_purchase")
    private Timestamp dateOfPurchase;

}
