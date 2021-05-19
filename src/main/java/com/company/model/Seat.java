package com.company.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "seat", schema = "public")
public class Seat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cinemaSeatId")
    private int cinemaSeatId;
    @Basic(optional = false)
    @Column(name = "seatNumber")
    private int seatNumber;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "seatStatus")
    private SeatStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Cinema cinema;


    public Seat() {
        this.status = SeatStatus.FREE;
    }

    public Seat(int seatNumber) {
        this.seatNumber=seatNumber;
        this.status = SeatStatus.FREE;
    }



}
