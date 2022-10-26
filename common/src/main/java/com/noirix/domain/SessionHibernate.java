package com.noirix.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Cacheable("session")
@Table(name = "session")
@EqualsAndHashCode(exclude = {
        "ticket"
})
@ToString(exclude = {
        "ticket"
})
public class SessionHibernate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "session_start")
    private Timestamp sessionStart;

    @Column(name = "end_of_session")
    private Timestamp endOfSession;

//    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private Set<TicketHibernate> ticket;

}