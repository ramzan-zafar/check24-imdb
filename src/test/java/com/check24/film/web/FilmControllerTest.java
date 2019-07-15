package com.check24.film.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.check24.common.model.transport.film.dto.FilmDto;
import com.check24.controller.AbstractControllerTest;
import com.check24.film.model.Film;
import com.check24.film.service.FilmService;

public class FilmControllerTest extends AbstractControllerTest {

	private static final String FILM_URL = "/api/v1/films";
	private static final List<Film> TEST_FILMS = createFilmList();
	private static final List<FilmDto> TEST_FILMS_DTO = createFilmDtoList();

	@Mock
	private FilmService filmService;

	@InjectMocks
	private FilmController underTest;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		setupControllerMvc(underTest);
	}

	@Test
	public void testReadAllShouldCallServiceAndShouldReturnObjects() throws Exception {

		when(filmService.findAllFilms()).thenReturn(TEST_FILMS_DTO);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get(FILM_URL).contentType(MediaType.APPLICATION_JSON_UTF8)
						.accept(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andReturn();

		verify(filmService, times(1)).findAllFilms();

		Assert.assertEquals(200, result.getResponse().getStatus());
	}

	private static List<Film> createFilmList() {

		List<Film> films = new ArrayList<>();

		for (int i = 0; i <= 3; i++) {

			films.add(createFilm(Long.valueOf(i), "Film" + i));
		}

		return films;

	}

	private static List<FilmDto> createFilmDtoList() {

		List<FilmDto> films = new ArrayList<>();

		for (int i = 0; i <= 3; i++) {

			films.add(createFilmDto(Long.valueOf(i), "Film" + i));
		}

		return films;

	}

	private static Film createFilm(Long filmid, String filmName) {
		Film film = new Film();
		film.setFilmId(filmid);
		film.setName(filmName);
		film.setDurationInMins(100);
		film.setYearOfRelease(2019);

		return film;
	}

	private static FilmDto createFilmDto(Long filmid, String filmName) {
		FilmDto film = new FilmDto();
		film.setFilmId(filmid);
		film.setName(filmName);
		film.setDurationInMins(100);
		film.setYearOfRelease(2019);

		return film;
	}
}
