//$Id$
package net.movies.movies;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HallService {

	@Autowired private HallRepository repo;
	
	public void save(Hall hall) {
		repo.save(hall);
	}
	
	public List<Hall> listAll() {
		return (List<Hall>) repo.findAll();
	}
	
	public Hall get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
