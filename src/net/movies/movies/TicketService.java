//$Id$
package net.movies.movies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TicketService {

	@Autowired
	private TicketRepository repo;
	
	public synchronized Ticket save(Ticket ticket) {
		return repo.save(ticket);
	}
	
	public List<Ticket> getAll() {
		return (List<Ticket>) repo.findAll();
	}
	
	public List<Ticket> findTicketsForScreening(Long screeningId) {
		return repo.getTicketsForScreening(screeningId);
	}
	
	public List<String> getAllSeats(Long screeningId) {
		List<String> str = new ArrayList<String>();
		List<Ticket> tickets = findTicketsForScreening(screeningId);
		for(Ticket t : tickets) {
			String s[] = t.getSeatNumbers().split(",");
			for(String i : s) {
				str.add("'" + i + "'");
			}
		}
		return str;
	}
	
	public Map<Long, String> getBlockedSeats(List<Long> screeningId) {
		Map<Long, String> blockedSeats = new HashMap<Long, String>();
		for(Long id : screeningId) {
			blockedSeats.put(id, getAllSeats(id).toString());
		}
		return blockedSeats;
	}
}
