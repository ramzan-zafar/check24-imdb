package com.check24.film.mapper;


import org.springframework.stereotype.Component;

import com.check24.common.model.transport.film.dto.FilmDto;
import com.check24.film.model.Film;

@Component
public interface FilmMapper {

	Film fromDto(FilmDto filmDto);
	
	FilmDto toDto(Film film);
}