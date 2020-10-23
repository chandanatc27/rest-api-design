package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Movie;


import com.javatechie.crud.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieDao;

    public Movie saveMovie(Movie movie) {
        return movieDao.save(movie);
    }

    public List<Movie> saveMovies(List<Movie> movies) {
        return movieDao.saveAll(movies);
    }

    public List<Movie> getMovies() {
        return movieDao.findAll();
    }
    public List<Movie> filterMovies(int rating){
    	return movieDao.filterByRatingOrderByYear(rating);
    }

    public Movie getMovieById(int id) {
        return movieDao.findById(id).orElse(null);
    }

    public Movie getMovieByName(String name) {
        return movieDao.findByName(name);
    }

    public String deleteMovie(int id) {
        movieDao.deleteById(id);
        return "movie removed !! " + id;
    }

//    public Product updateProduct(Product product) {
//        Product existingProduct = repository.findById(product.getId()).orElse(null);
//        existingProduct.setName(product.getName());
//        existingProduct.setQuantity(product.getQuantity());
//        existingProduct.setPrice(product.getPrice());
//        return repository.save(existingProduct);
//    }


}
