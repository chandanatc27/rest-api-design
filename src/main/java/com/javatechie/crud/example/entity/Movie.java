package com.javatechie.crud.example.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "Movie.filterByRatingOrderByYear",query="SELECT m from Movie m where m.rottenTomatoes > ?1 ORDER BY m.year ASC")
public class Movie {

	@Id
	@GeneratedValue
	public int id;
	public String name;
	public String genre;
	public String studio;
	public int rottenTomatoes;
	public int year;
	public Integer numUsers;
	
public Movie() {}
	
	public Movie(int id, String name, String genre, String studio, int rottenTomatoes, int year) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.studio = studio;
		this.rottenTomatoes = rottenTomatoes;
		this.year = year;
	}
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getStudio() {
		return studio;
	}


	public void setStudio(String studio) {
		this.studio = studio;
	}


	public int getRottenTomatoes() {
		return rottenTomatoes;
	}


	public void setRottenTomatoes(int rottenTomatoes) {
		this.rottenTomatoes = rottenTomatoes;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year=year;
	}

	public Integer getNumUsers() {
		return numUsers;
	}

	public void setNumUsers(Integer numUsers) {
		this.numUsers = numUsers;
	}
	
}
