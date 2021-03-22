//$Id$
package net.movies.movies;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ScreeningService {

	@Autowired
	private ScreeningRepository repo;
	public void save(Screening screen) {
        repo.save(screen);
    }
     
    public List<Screening> listAll() {
    	List<Screening> screening = (List<Screening>) repo.findAll();
    	for(Screening s : screening) {
    		s.setMovieName(repo.findMovie(s.getMovieId()).getMovieName());
    		s.setHallName(repo.findHall((Long)s.getHallId()).getHallName());
    	}
    	return screening;
    }
    
    public Screening get(Long id) {
        return repo.findById(id).get();
    }
     
    public void delete(Long id) {
        repo.deleteById(id);
    }

	public List<Screening> getMovieScreenings(Long id) {
		return repo.findMovieScreenings(id);
	}
 }
