//$Id$
package net.movies.movies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	
	private String movieName;
	private String language;
	private int movieStatus; 	// 0 - Unavailable, 1 - Available
	
	public Long getId() {
		return _id;
	}    
    public void setId(Long id) {
    	this._id = id;
    }
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getMovieStatus() {
		return movieStatus;
	}
	public void setMovieStatus(int movieStatus) {
		this.movieStatus = movieStatus;
	}
}

