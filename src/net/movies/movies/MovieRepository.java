//$Id$
package net.movies.movies;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{	//Type, IDType

	@Query(value = "SELECT c FROM Movie c WHERE c.movieName LIKE '%' || :keyword || '%'")
	List<Movie> searchByName(String query);	
	
	@Query(value = "SELECT c FROM Movie c WHERE c.language = ' || :keyword || '")
	List<Movie> searchByLanguage(String query);
}
