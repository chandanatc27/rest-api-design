package com.javatechie.crud.example.service;


import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.dto.CreateUserDto;
import com.javatechie.crud.example.entity.Movie;
import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.exceptions.MovieNotFoundException;
import com.javatechie.crud.example.exceptions.UserNotFoundException;
import com.javatechie.crud.example.repository.MovieRepository;
import com.javatechie.crud.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userDao;
	@Autowired
	private MovieRepository movieDao;
	
	
	public User saveUser(User user) {
		return userDao.save(user);
	}
	
	public User addToWatchlist(CreateUserDto createUserDto) {
		int userId=createUserDto.getUserId();
		User user=userDao.findById(userId).orElse(null);
		if(user==null) {
			throw new UserNotFoundException();
		}
		Collection<Movie> movies=user.getWatchlist();
		

		int id=createUserDto.getMovieId();
		
		Movie movie=movieDao.findById(id).orElse(null);
		if(movie==null) {
			throw new MovieNotFoundException();
		}
		
		if(!movies.contains(movie)) {
			
		Movie movieToUpdate = movie;
		int updatedNumUsers = movieToUpdate.getNumUsers()!= null
					? movieToUpdate.getNumUsers().intValue() + 1
					: 1;
			
		movieToUpdate.setNumUsers(Integer.valueOf(updatedNumUsers));
		movieDao.save(movieToUpdate);
		movies.add(movie);
		
		}
		
		return userDao.save(user);
		
		
	}
	
	public Collection<Movie> getWatchlist(int id) {
		return userDao.getWatchlist(id);
	}
	
	public Collection<Movie> removeFromWatchlist(int userId,int movieId){
		
		User user=userDao.findById(userId).orElse(null);
		if(user==null) {
			throw new UserNotFoundException();
		}
		Movie movie=movieDao.findById(movieId).orElse(null);
		
		Collection<Movie> movies=user.getWatchlist();
		if(movies.contains(movie)) {
			movies.remove(movie);
		}
		else {
			throw new MovieNotFoundException();
		}
		return movies;
			
	}
	
//	public String removeFromWatchlist(int userId,int movieId){
//		String msg;
//		
//		User user=userDao.findById(userId).orElse(null);
//		if(user==null) {
//			throw new UserNotFoundException();
//		}
//		Movie movie=movieDao.findById(movieId).orElse(null);
//		
//		Collection<Movie> movies=user.getWatchlist();
//		if(movies.contains(movie)) {
//			movies.remove(movie);
//			Movie movieToUpdate = movie;
//			int updatedNumUsers = movieToUpdate.getNumUsers()!= null
//						? movieToUpdate.getNumUsers().intValue() - 1
//						: 0;
//			movieToUpdate.setNumUsers(Integer.valueOf(updatedNumUsers));
//			movieDao.save(movieToUpdate);
//			msg="movie removed from watchlist";
//		}
//		else {
//			msg="movie not found";
//		}
//		return msg;
//			
//		
//	}
	
}
