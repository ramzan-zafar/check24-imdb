package com.check24.film.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.check24.film.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
		
	List<Film> findAllByNameContainingIgnoreCase(String name);
}