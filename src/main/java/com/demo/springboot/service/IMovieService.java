package com.demo.springboot.service;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMovieService {
    ResponseEntity<Void> addMovie(MovieDto movieDto);
    ResponseEntity<List<MovieDto>> getMovieList();
    ResponseEntity<Object> updateMovie(int id, CreateMovieDto createMovieDto);
    ResponseEntity<Object> deleteMovie(int id);
}
