package com.demo.springboot.entity;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Movie {
        private Integer movieId;
        private String title;
        private Integer year;
        private String image;

    public Movie(MovieDto movieDto) {
        this.movieId = movieDto.getMovieId();
        this.title = movieDto.getTitle();
        this.year = movieDto.getYear();
        this.image = movieDto.getImage();
    }

    public void updateMovieData(CreateMovieDto createMovieDto){
        this.title = createMovieDto.getTitle();
        this.year = createMovieDto.getYear();
        this.image = createMovieDto.getImage();
    }
}
