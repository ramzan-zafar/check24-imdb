package com.check24.film.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.check24.common.model.transport.film.dto.FilmDto;
import com.check24.common.model.transport.rating.dto.RatingDto;
import com.check24.exception.ResourceNotFoundException;
import com.check24.film.mapper.FilmMapper;
import com.check24.film.model.Film;
import com.check24.film.repository.FilmRepository;
import com.check24.film.service.FilmService;
import com.check24.rating.model.Rating;
import com.check24.security.service.UserPrinciple;
import com.check24.user.model.User;
import com.check24.user.repository.UserRepository;

/**
 * Implementation of the FilmService.
 * 
 * @author Ramzan_Zafar
 */

@Component
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmRepository filmRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	FilmMapper filmMapper;

	@Override
	public List<FilmDto> findAllFilms() {

		List<Film> films = filmRepository.findAll();

		return films.stream().map(film -> filmMapper.toDto(film)).collect(Collectors.toList());

	}

	@Override
	public List<FilmDto> findAllFilmByName(String name) {
		List<Film> films = filmRepository.findAllByNameContainingIgnoreCase(name);

		return films.stream().map(film -> filmMapper.toDto(film)).collect(Collectors.toList());
	}

	@Override
	public FilmDto rateFilm(RatingDto ratingDto) {

		Optional<Film> film = filmRepository.findById(ratingDto.getFilmId());

		if (film.isPresent()) {

			User user = getUserFromSecurityContext();

			Rating userRating = populateRating(ratingDto, film, user);

			if (CollectionUtils.isEmpty(film.get().getRating())) {
				Set<Rating> rating = new HashSet<>();
				film.get().setRating(rating);
			}

			film.get().getRating().add(userRating);

			filmRepository.save(film.get());
		} else {
			throw new ResourceNotFoundException(String.valueOf(ratingDto.getFilmId()),
					"film with this id does not exist");
		}

		return filmMapper.toDto(film.get());
	}

	private Rating populateRating(RatingDto ratingDto, Optional<Film> film, User user) {
		Rating userRating = new Rating();
		userRating.setUser(user);
		userRating.setFilm(film.get());
		userRating.setRating(ratingDto.getRating());
		return userRating;
	}

	private User getUserFromSecurityContext() {
		UserPrinciple userDetails = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = userRepository.findById(userDetails.getId()).get();
		return user;
	}

}