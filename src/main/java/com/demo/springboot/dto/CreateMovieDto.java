package com.demo.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter

public class CreateMovieDto{
    private String title;
    private Integer year;
    private String image;
}
