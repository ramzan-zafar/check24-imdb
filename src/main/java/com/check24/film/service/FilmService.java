package com.check24.film.service;


import java.util.List;

import com.check24.common.model.transport.film.dto.FilmDto;
import com.check24.common.model.transport.rating.dto.RatingDto;


/**
 * Film Service
 * @author Ramzan_Zafar
 */
public interface FilmService {

    List<FilmDto> findAllFilms();
    
    List<FilmDto> findAllFilmByName(String name); 
    
    FilmDto rateFilm(RatingDto rating);
}
