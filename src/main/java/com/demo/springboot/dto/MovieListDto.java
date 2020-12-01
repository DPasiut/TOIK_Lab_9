package com.demo.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter

public class MovieListDto {
    private List<MovieDto> movies;

    @Override
    public String toString() {
        return "[" + movies.stream()
                .map(movie -> movie.getMovieId().toString())
                .collect(Collectors.joining(",")) + "]";
    }
}
