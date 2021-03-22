package net.movies.movies;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
 
@Controller
public class MainController {
 
    @Autowired
    private CustomerService customerService;
 
    @Autowired
    private MovieService movieService;
    
    @Autowired
    private HallService hallService;
    
    @Autowired
    private ScreeningService screeningService;
    
    @Autowired
    private TicketService ticketService;
    
    @Autowired
    private PaymentService paymentService;
    
    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("/index");
        return mav;
    } 
    
    //Customer Related Action Mappings
    @RequestMapping("/newCustomer")
    public String newCustomer(Map<String, Object> model) {
    	Customer customer = new Customer();
    	model.put("customer", customer);
    	return "/newCustomer";
    }
    
    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST, params = "!cancel")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
    	customerService.save(customer);
    	return getModel("/listCustomer", "customer");
    }
    
    @RequestMapping("/editCustomer")
    public ModelAndView editCustomer(@RequestParam Long id) {
    	ModelAndView mav = new ModelAndView("/editCustomer");
    	Customer customer = customerService.get(id);
    	mav.addObject("customer", customer);
    	return mav;
    }

    @RequestMapping(value = "/deleteCustomer")
    public String deleteCustomer(@RequestParam Long id) {
    	customerService.delete(id);
    	return "redirect:/listCustomer";
    }
    
    @RequestMapping("/listCustomer")
    public String listCustomer(Map<String, Object> model) {
    	List<Customer> customer = customerService.listAll();
    	model.put("customers", customer);
    	return "/listCustomer";
    }
    
    //Movie Related Action Mappings
    @RequestMapping("/newMovie")
    public String newMovie(Map<String, Object> model) {
    	Movie movie = new Movie();
    	model.put("movie", movie);
    	return "/newMovie";
    }
    
    @RequestMapping(value = "/saveMovie", method = RequestMethod.POST, params = "!cancel")
    public ModelAndView saveMovie(@ModelAttribute("movie") Movie movie) {
    	movieService.save(movie);
    	return getModel("/listMovie", "movie");
    }
    
    @RequestMapping("/editMovie")
    public ModelAndView editMovie(@RequestParam Long id) {
    	ModelAndView mav = new ModelAndView("/editMovie");
    	Movie movie = movieService.get(id);
    	mav.addObject("movie", movie);
    	return mav;
    }
    
    @RequestMapping(value = "/deleteMovie")
    public String deleteMovie(@RequestParam Long id) {
    	movieService.delete(id);
    	return "redirect:/listMovie";
    }
    
    @RequestMapping("/listMovie")
    public String listMovie(Map<String, Object> model) {
    	List<Movie> movie = movieService.listAll();
    	model.put("movies", movie);
    	return "/listMovie";
    }
    
    //Hall Related Action Mappings
    @RequestMapping("/newHall")
    public String newHall(Map<String, Object> model) {
    	Hall hall = new Hall();
    	model.put("hall", hall);
    	return "/newHall";
    }
    
    @RequestMapping(value = "/saveHall", method = RequestMethod.POST, params = "!cancel")
    public ModelAndView saveHall(@ModelAttribute("hall") Hall hall) {
    	hallService.save(hall);
    	return getModel("/listHall", "hall");
    }
    
    @RequestMapping("/editHall")
    public ModelAndView editHall(@RequestParam Long id) {
    	ModelAndView mav = new ModelAndView("/editHall");
    	Hall hall = hallService.get(id);
    	mav.addObject("hall", hall);
    	return mav;
    }
    
    @RequestMapping(value = "/deleteHall")
    public String deleteHall(@RequestParam Long id) {
    	hallService.delete(id);
    	return "redirect:/listHall";
    }

    @RequestMapping("/listHall")
    public String listHall(Map<String, Object> model) {
    	List<Hall> hall = hallService.listAll();
    	model.put("halls", hall);
    	return "/listHall";
    }
    
  //Screening Related Action Mappings
    @RequestMapping("/newScreening")
    public String newScreening(Map<String, Object> model) {
    	Screening screening = new Screening();
    	model.put("halls", hallService.listAll());
    	model.put("movies", movieService.listAll());
    	model.put("screening", screening);
    	return "/newScreening";
    }
    
    @RequestMapping(value = "/saveScreening", method = RequestMethod.POST, params = "!cancel")
    public ModelAndView saveScreening(@RequestParam("movieId") Long movieId, @RequestParam("hallId") Long hallId, @RequestParam("startingTime") String startingTime) throws ParseException {
    	Screening screening = new Screening();
    	screening.setHallId(hallId);
    	screening.setMovieId(movieId);
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy hh:mm a");
        Date theDate = sdf.parse(startingTime);
        screening.setStartingTime(theDate);
    	screeningService.save(screening);
    	return getModel("/listScreening", "screening");
    }
    
    @RequestMapping("/editScreening")
    public ModelAndView editScreening(@RequestParam Long id) {
    	ModelAndView mav = new ModelAndView("/editScreening");
    	Screening screening = screeningService.get(id);
    	mav.addObject("screening", screening);
    	return mav;
    }
    
    @RequestMapping(value = "/deleteScreening")
    public String deleteScreening(@RequestParam Long id) {
    	screeningService.delete(id);
    	return "redirect:/listScreening";
    }

    @RequestMapping("/listScreening")
    public String listScreening(Map<String, Object> model) {
    	List<Screening> screening = screeningService.listAll();
    	model.put("screenings", screening);
    	return "/listScreening";
    }
    
    
    
    
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String query) {
    	ModelAndView mav = new ModelAndView("/searchResults");
    	List<Customer> search = customerService.search(query);
    	if(search.size() > 0) {
    		mav.addObject("customers", search);
    	}
    	mav.addObject("size", search.size());
    	return mav;
    }
    
    
    //Ticket Related Action Mappings
    @RequestMapping("/bookTicket")
    public ModelAndView bookTicket() {
    	Ticket ticket = new Ticket();
    	ModelAndView mav = new ModelAndView("/bookTicket");
    	mav.addObject("movies", movieService.listAll());
    	mav.addObject("ticket", ticket);
    	return mav;
    }
    
    @RequestMapping(value = "/getScreenings", method = RequestMethod.POST)
    public ModelAndView getScreenings(@RequestParam String movieId) {
    	ModelAndView mav = new ModelAndView("/getScreenings");
    	Ticket ticket = new Ticket();
    	List<Screening> s = (List<Screening>) screeningService.getMovieScreenings(Long.parseLong(movieId));
    	List<Long> screeningIds = new ArrayList<Long>();
    	for(Screening i : s) {
    		screeningIds.add(i.getId());
    	}
    	mav.addObject("movie", movieService.get(Long.parseLong(movieId)).getMovieName());
    	mav.addObject("customerId", 4);
    	mav.addObject("screenings", s);
    	mav.addObject("screeningIds", screeningIds);
    	JSONObject j = new JSONObject(ticketService.getBlockedSeats(screeningIds));
    	mav.addObject("selectedSeats", j.toString());
    	mav.addObject("movieId", movieId);
    	mav.addObject("ticket", ticket);
    	return mav;
    }
    
    @RequestMapping("/saveTicket")
    public String saveTicket(@RequestParam("customerId") Long customerId, @RequestParam("movieId") Long movieId, @RequestParam("screeningId") Long screeingId, @RequestParam("seatNumbers") String seatNumbers) {
    	Customer customer = customerService.get(customerId);
    	synchronized(customer) {
    		Random random = new Random();
    		if(random.nextBoolean()) {
    			Ticket ticket = new Ticket();
    			ticket.setCustomerId(customerId);
    			ticket.setScreeningId(screeingId);
    			ticket.setSeatNumbers(seatNumbers);
    			ticket = ticketService.save(ticket);
    			
    			Payment payment = new Payment();
    			payment.setStatus(1);
    			payment.setTicketId(ticket.getId());
    			paymentService.save(payment);
    		}
    	}
        return "redirect:/";
    }
    
    @RequestMapping(params = "cancel", method = RequestMethod.POST)
    public String cancelAction() {
    	return "redirect:/";
    }
    
    
    private ModelAndView getModel(String file, String object) {
    	ModelAndView mav = new ModelAndView(file);
    	switch(object) {
    	case "hall":
    		List<Hall> hall = hallService.listAll();
        	mav.addObject("halls", hall);	
        	break;
    	case "movie":
    		List<Movie> movie = movieService.listAll();
    		mav.addObject("movies", movie);
    		break;
    	case "customer":
    		List<Customer> customers = customerService.listAll();
    		mav.addObject("customers", customers);
    		break;
    	case "screening":
    		List<Screening> screenings = screeningService.listAll();
    		mav.addObject("screenings", screenings);
    		break;
    	}
    	return mav;
    }
}