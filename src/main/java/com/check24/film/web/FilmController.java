package com.check24.film.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.check24.common.model.transport.film.dto.FilmDto;
import com.check24.common.model.transport.rating.dto.RatingDto;
import com.check24.film.service.FilmService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 */
@RestController
@RequestMapping("/api/v1/")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@ApiOperation(value = "Return list of films", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = FilmDto.class),
			@ApiResponse(code = 400, message = "Bad Request - Invalid request parameters", responseContainer = "List") })
	@GetMapping(value = "/films", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity<List<FilmDto>> readAll() {
		return ResponseEntity.ok(filmService.findAllFilms());
	}
	
	@ApiOperation(value = "Seach films based on given name", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = FilmDto.class),
			@ApiResponse(code = 400, message = "Bad Request - Invalid request parameters", responseContainer = "List") })
	@GetMapping(value = "/films/{name}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity<List<FilmDto>> findAllByName(@PathVariable(value="name") String name) {
		return ResponseEntity.ok(filmService.findAllFilmByName(name));
	}
	
	@ApiOperation(value = "Rate film", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = FilmDto.class),
			@ApiResponse(code = 400, message = "Bad Request - Invalid request parameters", responseContainer = "List") })
	@PostMapping(value = "/films/rate", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity<FilmDto> rateFIlm(@Valid @RequestBody RatingDto rating) {
		return ResponseEntity.ok(filmService.rateFilm(rating));
	}
	
}