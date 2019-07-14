package com.check24.filmgenre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.check24.film.model.Film;
import com.check24.user.model.Genre;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="FILM_GENRE")
public class FilmGenre{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="genreId")
	private Genre genre;
	
	@ManyToOne
	@JoinColumn(name="filmId")
	private Film film;
}