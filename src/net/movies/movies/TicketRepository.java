//$Id$
package net.movies.movies;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long>{
	
	@Query("FROM Ticket s where screeningId = :id ")
	public List<Ticket> getTicketsForScreening(@Param("id") Long id);
}
