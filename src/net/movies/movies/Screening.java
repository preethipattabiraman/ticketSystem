//$Id$
package net.movies.movies;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Screening {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	@Column
	private Long movieId;
	@Column
	private Long hallId;
	
	@Column(name="startingTime")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MMM/yyyy hh:mm a")
	private Date startingTime;

	public Date getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}

	public Long getId() {
		return _id;
	}    
    public void setId(Long id) {
    	this._id = id;
    }
    
	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getHallId() {
		return hallId;
	}

	public void setHallId(Long hallId) {
		this.hallId = hallId;
	}
	@Transient
	public String getMovieName() {
		return movieName;
	}
	@Transient
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@Transient
	public String getHallName() {
		return hallName;
	}
	@Transient
	public void setHallName(String hallNAme) {
		this.hallName = hallNAme;
	}
	@Transient
	private String movieName;
	@Transient
	private String hallName;
}

