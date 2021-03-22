//$Id$
package net.movies.movies;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	@Column
	private Long screeningId;
	@Column
	private Long customerId;
	@Column
	private String seatNumbers;
	
	public Long getId() {
		return _id;
	}    
    public void setId(Long id) {
    	this._id = id;
    }
    
    public Long getScreeningId() {
		return screeningId;
	}    
    public void setScreeningId(Long screeningId) {
    	this.screeningId = screeningId;
    }

    public Long getCustomerId() {
		return customerId;
	}    
    public void setCustomerId(Long customerId) {
    	this.customerId = customerId;
    }

    public String getSeatNumbers() {
		return seatNumbers;
	}    
    public void setSeatNumbers(String seatNumbers) {
    	this.seatNumbers = seatNumbers;
    }
}
