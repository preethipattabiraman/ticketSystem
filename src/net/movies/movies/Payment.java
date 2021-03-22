//$Id$
package net.movies.movies;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	@Column
	private Long ticketId;
	@Column
	private int status;
	
	public Long getId() {
		return _id;
	}    
    public void setId(Long id) {
    	this._id = id;
    }
    
    public Long getTicketId() {
		return ticketId;
	}    
    public void setTicketId(Long ticketId) {
    	this.ticketId = ticketId;
    }
    
    public int getStatus() {
		return status;
	}    
    public void setStatus(int status) {
    	this.status = status;
    }
}
