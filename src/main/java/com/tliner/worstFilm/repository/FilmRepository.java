package com.tliner.worstFilm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tliner.worstFilm.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByIsWinner(Boolean winner);

}
