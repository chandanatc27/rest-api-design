package com.javatechie.crud.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javatechie.crud.example.dto.CreateUserDto;
import com.javatechie.crud.example.entity.Movie;
import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/user")
   public User addUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PatchMapping("/user/watchlist")
	public User addToWatchlist(@RequestBody CreateUserDto createUserDto) {
		return service.addToWatchlist(createUserDto);
	}
	
	@GetMapping("/user/{id}/watchlist")
	public Collection<Movie> getUser(@PathVariable int id) {
		return service.getWatchlist(id);
	}
	
	
	@DeleteMapping("/user/{id1}/watchlist/{id2}")
	public  Collection<Movie>removeFromWatchlist(@PathVariable int id1,@PathVariable int id2) {
		return service.removeFromWatchlist(id1, id2);
	}
	
	
}
