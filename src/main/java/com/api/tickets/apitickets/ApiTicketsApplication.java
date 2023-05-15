package com.api.tickets.apitickets;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.tickets.apitickets.data.TicketRepository;
import com.api.tickets.apitickets.data.models.Ticket;
import com.api.tickets.apitickets.data.models.TicketInformation;



@SpringBootApplication
@RestController
public class ApiTicketsApplication {

	@Autowired
	private TicketRepository ticketRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiTicketsApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("/ticket")
	public @ResponseBody Ticket createTicket(@RequestBody TicketInformation ticketInformation) {
		Ticket ticket = new Ticket();
		ticket.setUserId(ticketInformation.getUserId());
		ticket.setCreationDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		ticket.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		return ticketRepository.save(ticket);
	}

	@DeleteMapping("/ticket/{id}")
	public @ResponseBody void deleteTicket(@PathVariable("id") int id) {
		Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		optionalTicket.ifPresent((ticket) -> ticketRepository.delete(ticket));
	}

	@GetMapping("/ticket/{id}")
	public @ResponseBody Ticket searchTicket(@PathVariable("id") int id) {
		return ticketRepository.findById(id).orElseGet(null);
		
	}

	@GetMapping("/ticket")
	public @ResponseBody Iterable<Ticket> allTicket(){
		return ticketRepository.findAll();
	}

	@PutMapping("/ticket/{id}")
	public @ResponseBody Ticket updateTicket(
		@RequestBody TicketInformation ticketInformation,
		@PathVariable("id") int id) {
		Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		return optionalTicket.map((ticket) -> {
			ticket.setUserId(ticketInformation.getUserId());
			ticket.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			return ticket;
		})
		.map((ticket) -> ticketRepository.save(ticket))
		.orElseGet(null);
	}

}
