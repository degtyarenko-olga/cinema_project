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
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "session")
@EqualsAndHashCode(exclude = {
        "ticket"
})
public class Session {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "session_start")
    private Timestamp sessionStart;

    @Column(name = "end_of_session")
    private Timestamp endOfSession;

    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<Ticket> ticket;

}
