package com.company.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "show", schema = "public")
public class Show implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "show_id")
    private int showId;

    @Basic(optional = false)
    @Column(name = "show_date")
    private String show_date;
    @Basic(optional = false)
    @Column(name = "start_time")
    private String start_time;
    @Basic(optional = false)
    @Column(name = "end_time")
    private String end_time;
//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    private Movie movie;
//    @ManyToOne
//    @JoinColumn(name = "cinema_id")
//    private Cinema cinema;






}
