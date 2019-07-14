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
	
	@OneToMany(mappedBy="film",fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	private Set<Rating> rating;
		
}