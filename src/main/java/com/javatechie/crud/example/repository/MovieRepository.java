package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findByName(String name);
    List<Movie> filterByRatingOrderByYear(int rating);
}

