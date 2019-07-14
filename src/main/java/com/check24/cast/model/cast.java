package com.check24.cast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.check24.film.model.Film;
import com.check24.actor.model.Actor;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="CAST")
public class Cast {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="actorId")
	private Actor actor;
	
	@ManyToOne
	@JoinColumn(name="filmId")
	private Film film;
	
	@Column(name="role")
	private String roleName;
	
}