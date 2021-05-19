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
@NoArgsConstructor
@Table(name = "movie", schema = "public")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "image_url")
    private  String imageURL;
    @Basic(optional = false)
    @Column(name = "movie_name")
    private String movieName;
    @Basic(optional = false)
    @Column(name = "movie_description")
    private String movieDescription;
    @Basic(optional = false)
    @Column(name = "movie_duration")
    private String movieDuration;
    @Basic(optional = false)
    @Column(name = "language")
    private String language;
    @Basic(optional = false)
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "genre_name")
    private String genreName;


    public Movie(String movieName, String movieDescription, String movieDuration, String language, String releaseDate, String country, String genre) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieDuration = movieDuration;
        this.language = language;
        this.releaseDate = releaseDate;
        this.countryName = country;
        this.genreName = genre;
    }
}
