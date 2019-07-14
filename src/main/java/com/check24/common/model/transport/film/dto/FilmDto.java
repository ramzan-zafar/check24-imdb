package com.check24.common.model.transport.film.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FilmDto {

	private Long filmId;

	@NotBlank
	private String name;

	private Integer yearOfRelease;

	private Integer durationInMins;

	private Double averageRating;

	private List<String> cast;

	private List<String> directors;

	private List<String> genres;

}
