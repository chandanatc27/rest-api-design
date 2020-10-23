package com.javatechie.crud.example.dto;

import java.util.List;

public class CreateUserDto {

	
	
public CreateUserDto(int userId, int movieId) {
		super();
		this.userId = userId;
		this.movieId = movieId;
	}
//	public CreateUserDto(int userId, List<Integer> movieIds) {
//		super();
//		this.userId = userId;
//		this.movieIds = movieIds;
//	}
	public int userId;
	public int movieId;
//	public List<Integer> movieIds;

	public CreateUserDto() {
		super();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

//	public List<Integer> getMovieIds() {
//		return movieIds;
//	}
//
//	public void setMovieIds(List<Integer> movieIds) {
//		this.movieIds = movieIds;
//	}
	
	
	
}
