package com.javatechie.crud.example.repository;

import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.javatechie.crud.example.entity.Movie;
import com.javatechie.crud.example.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User,Integer> {

	Collection<Movie> getWatchlist(int id);
}
