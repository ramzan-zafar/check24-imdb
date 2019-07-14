package com.check24.filmdirector.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.check24.director.model.Director;
import com.check24.film.model.Film;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="FILM_DIRECTOR")
public class FilmDirector {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="directorId")
	private Director director;
	
	@ManyToOne
	@JoinColumn(name="filmId")
	private Film film;
}