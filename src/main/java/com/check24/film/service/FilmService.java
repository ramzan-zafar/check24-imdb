package com.check24.film.service;


import java.util.List;

import com.check24.common.model.transport.film.dto.FilmDto;
import com.check24.common.model.transport.rating.dto.RatingDto;

/**
 * Film Service
 * @author Ramzan_Zafar
 */
public interface FilmService {

    /**
     * Method to find all films
     * @return list of {@link FilmDto}
     */
    List<FilmDto> findAllFilms();
    
    /**
     * Method to find all film by given name
     * @param name
     * @return list of matching {@link FilmDto} against provided name
     */
    List<FilmDto> findAllFilmByName(String name); 
    
    /**
     * Method to rate a film against provided rating
     * @param rating {@link RatingDto}
     * @return {@link FilmDto}
     */
    FilmDto rateFilm(RatingDto rating);
}
