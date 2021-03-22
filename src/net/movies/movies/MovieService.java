//$Id$
package net.movies.movies;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {

	@Autowired
	private MovieRepository repo;
	public void save(Movie movie) {
        repo.save(movie);
    }
     
    public List<Movie> listAll() {
        return (List<Movie>) repo.findAll();
    }
     
    public Movie get(Long id) {
        return repo.findById(id).get();
    }
     
    public void delete(Long id) {
        repo.deleteById(id);
    }
     
    public List<Movie> searchByMovieName(String query) {
    	return repo.searchByName(query);
    }
    
    public List<Movie> searchByMovieLanguage(String query) {
    	return repo.searchByLanguage(query);
    }
	
}
