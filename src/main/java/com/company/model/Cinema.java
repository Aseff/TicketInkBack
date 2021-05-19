package com.company.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "cinema_hall", schema = "public")
public class Cinema implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long cinemaId;

    @Basic(optional = false)
    @Column(name = "hall_name")
    private  String name;

    @Basic(optional = false)
    @Column(name = "address")
    private  String address;

    @Column(name = "total_seats")
    private int totalSeats;

    @Basic(optional = false)
    @Column(name = "image_url")
    private String imageURL;
    public Cinema(){

    }
    public Cinema(String name, String address, int totalSeats, String imageURL) {
        this.name = name;
        this.address = address;
        this.totalSeats = totalSeats;
        this.imageURL = imageURL;
    }
}
