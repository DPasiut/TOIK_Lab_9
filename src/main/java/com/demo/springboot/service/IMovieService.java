package com.demo.springboot.service;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import com.demo.springboot.dto.MovieListDto;
import org.springframework.http.ResponseEntity;

public interface IMovieService {
    ResponseEntity<Void> addMovie(MovieDto movieDto);
    MovieListDto getMovieList();
    ResponseEntity<Object> updateMovie(int id, CreateMovieDto createMovieDto);
    ResponseEntity<Object> deleteMovie(int id);
}
