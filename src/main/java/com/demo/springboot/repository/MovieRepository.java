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
    private List<Movie> movies;

    public MovieRepository(){
        movies = new ArrayList<>();
    }

    public void addMovie(MovieDto movieDto){
        this.movies.add(new Movie(movieDto));
    }

    public Movie getById(int id){
        return movies.stream().filter(movie -> movie.getMovieId() == id).findFirst().orElse(null);
    }

    public void deleteMovie(int id){
        this.movies.remove(id);
    }

    public List<Movie> getMovieList(){
        return this.movies;
    }

}
