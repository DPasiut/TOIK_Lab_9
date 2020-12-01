package com.demo.springboot.dto;


import com.demo.springboot.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Getter

public class MovieDto {
    private Integer movieId;
    private String title;
    private Integer year;
    private String image;


    public MovieDto(Movie movie){
        this.movieId = movie.getMovieId();
        this.title = movie.getTitle();
        this.year = movie.getYear();
        this.image = movie.getImage();
    }
}
