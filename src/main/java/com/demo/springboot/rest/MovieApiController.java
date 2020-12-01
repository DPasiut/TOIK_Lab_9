package com.demo.springboot.rest;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import com.demo.springboot.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieApiController {
    private static final Logger LOG = LoggerFactory.getLogger(MovieApiController.class);


    private final MovieService movieService;
    public MovieApiController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/api/movies")
    public ResponseEntity<Void> createMovie(@RequestBody MovieDto movieDto) {
        return movieService.addMovie(movieDto);
    }

    @GetMapping("/api/movies/get")
    public ResponseEntity<List<MovieDto>> getMovies() {
        return movieService.getMovieList();
    }

    @PutMapping("/api/movies/{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable("id") Integer id,
                                              @RequestBody CreateMovieDto createMovieDto){
        return movieService.updateMovie(id, createMovieDto);
    }

    @DeleteMapping("/api/movies/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable("id") Integer id){
        return movieService.deleteMovie(id);
    }
}
