//$Id$
package net.movies.movies;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening, Long>{
	@Query("FROM Movie m where m._id = :id")
    Movie findMovie(@Param("id") Long i);
	@Query("FROM Hall h where h._id = :id")
	Hall findHall(@Param("id") Long id);
	@Query("SELECT s from Screening s where movieId = :movieId")
	List<Screening> findMovieScreenings(@Param("movieId") Long id);
}
