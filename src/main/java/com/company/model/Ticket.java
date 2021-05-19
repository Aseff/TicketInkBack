package com.company.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "ticket", schema = "public")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private String ticketId;
    @Basic(optional = false)
    @Column(name = "number_of_seats")
    private int numberOfSeats;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;


}
