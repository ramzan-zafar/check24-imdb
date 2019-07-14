package com.check24.film.mapper.impl;


import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.check24.common.model.transport.film.dto.FilmDto;
import com.check24.film.mapper.FilmMapper;
import com.check24.film.model.Film;

@Component
public class FilmMapperImpl implements FilmMapper {

	@Override
	public Film fromDto(FilmDto filmDto) {
		Film film = new Film();
		film.setFilmId(filmDto.getFilmId());
		film.setName(filmDto.getName());
		film.setYearOfRelease(filmDto.getYearOfRelease());
		film.setDurationInMins(film.getDurationInMins());
		return film;
	}

	@Override
	public FilmDto toDto(Film film) {

		FilmDto filmDto = new FilmDto();		
		filmDto.setFilmId(film.getFilmId());
		filmDto.setName(film.getName());
		filmDto.setYearOfRelease(film.getYearOfRelease());
		filmDto.setDurationInMins(film.getDurationInMins());
		filmDto.setAverageRating(calculateAverageRating(film));
						
		return filmDto;
	}

	private Double calculateAverageRating(Film film) {
		return film.getRating().stream().map(r-> r.getRating()).collect(Collectors.averagingInt(Integer::intValue));
	}

	
}