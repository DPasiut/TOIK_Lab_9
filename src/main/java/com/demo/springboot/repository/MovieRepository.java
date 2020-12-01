package com.demo.springboot.repository;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import com.demo.springboot.dto.MovieListDto;
import com.demo.springboot.entity.Movie;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Repository
public class MovieRepository {

    private List<Movie> movies = new ArrayList<>();

    public MovieRepository(){
        movies.add(new Movie(1,"Pierwszy",2020,"image1"));
        movies.add(new Movie(2,"Drugi",2020,"image2"));
        movies.add(new Movie(3,"Trzeci",2020,"image3"));
    }

    public void addMovie(MovieDto movieDto){
        this.movies.add(new Movie(movieDto));
    }

    public Movie getById(int id){
        return movies.stream().filter(movie -> movie.getMovieId() == id).findFirst().orElse(null);
    }

    public void deleteMovie(int id){
        this.movies.remove(movies.stream().filter(movie -> movie.getMovieId() == id).findFirst().orElse(null));
    }

    public List<Movie> getMovieList(){
        return this.movies;
    }

}
