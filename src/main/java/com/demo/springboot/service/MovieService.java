package com.demo.springboot.service;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import com.demo.springboot.dto.MovieListDto;
import com.demo.springboot.entity.Movie;
import com.demo.springboot.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<Void> addMovie(MovieDto movieDto){

        if(movieDto.getImage() == "" ||
                movieDto.getMovieId() == null ||
                movieDto.getTitle() == "" ||
                movieDto.getYear() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        movieRepository.addMovie(movieDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public MovieListDto getMovieList(){

        List<MovieDto> movieDtoList = new ArrayList<>();
        List<Movie> temp = movieRepository.getMovieList();
        MovieDto movieDto;

        for(int i = 0; i < temp.size(); i++){
            movieDto = new MovieDto(
                    temp.get(i).getMovieId(),
                    temp.get(i).getTitle(),
                    temp.get(i).getYear(),
                    temp.get(i).getImage());
            movieDtoList.add(movieDto);
        }

        return new MovieListDto(movieDtoList);
    }

    public ResponseEntity<Object> updateMovie(int id, CreateMovieDto createMovieDto){

        if (movieRepository.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieRepository.getById(id).updateMovieData(createMovieDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteMovie(int id){
        if (movieRepository.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieRepository.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
