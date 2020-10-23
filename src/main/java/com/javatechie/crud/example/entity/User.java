package com.javatechie.crud.example.entity;

import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;



@Entity
@NamedQuery(name = "User.getWatchlist", query = "select u.watchlist from User u where u.id = ?1")
public class User {

	public User() {
		
	}
	public User(int id, String name, String email, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		
	}

	@Id
	@GeneratedValue
	public int id;
	public String name;
	public String email;
	public String pwd;
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="user_movie", joinColumns = { @JoinColumn(name = "user_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "movie_id") }) 
	public Collection<Movie> watchlist;

	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Collection<Movie> getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(Collection<Movie> watchlist) {
		this.watchlist = watchlist;
	}
	
	
	
}
