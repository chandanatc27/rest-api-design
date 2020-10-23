package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Movie;


import com.javatechie.crud.example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie) {
        return service.saveMovie(movie);
    }

    @PostMapping("/movies")
    public List<Movie> addMovies(@RequestBody List<Movie> movies) {
        return service.saveMovies(movies);
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return service.getMovies();
    }

    @GetMapping("/movie/{id}")
    public Movie findMovieById(@PathVariable int id) {
        return service.getMovieById(id);
    }

    @GetMapping("/movie/{name}")
    public Movie findMovieByName(@PathVariable String name) {
        return service.getMovieByName(name);
    }

//    @PutMapping("/update")
//    public Product updateProduct(@RequestBody Product product) {
//        return service.updateProduct(product);
//    }

    @DeleteMapping("/movie/{id}")
    public String deleteMovie(@PathVariable int id) {
        return service.deleteMovie(id);
    }
    @GetMapping("/movies-in-theaters")
    public List<Movie> filterMovies(@RequestParam(value="rating") int rating){
    	return service.filterMovies(rating);
    }
}
