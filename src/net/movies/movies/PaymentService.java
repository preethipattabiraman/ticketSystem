//$Id$
package net.movies.movies;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentService {

	@Autowired
	private PaymentRepository repo;
	
	public void save(Payment payment) {
		repo.save(payment);
	}
}
