package com.check24.film.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.check24.rating.model.Rating;
import com.check24.cast.model.Cast;
import com.check24.filmdirector.model.FilmDirector;
import com.check24.filmgenre.model.FilmGenre;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
@Table(name="FILM")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="filmId")
	private Long filmId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="year_of_release")
	private Integer yearOfRelease;
	
	@Column(name="duration_in_mins")
	private Integer durationInMins;
	
	@OneToMany(mappedBy="film",fetch = FetchType.LAZY, cascade= CascadeType.MERGE)
	private Set<Rating> rating;
	
	@OneToMany(mappedBy="film",fetch = FetchType.LAZY, cascade= CascadeType.MERGE)
	private Set<FilmDirector> directors;
	
	@OneToMany(mappedBy="film",fetch = FetchType.LAZY, cascade= CascadeType.MERGE)
	private Set<FilmGenre> genres;

    @OneToMany(mappedBy="film",fetch = FetchType.LAZY, cascade= CascadeType.MERGE)
	private Set<Cast> cast;	
}