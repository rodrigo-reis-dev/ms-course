package hr.payroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.payroll.entities.Payment;
import hr.payroll.services.PaymentService;

// O resource, libera um endpoint na web
@RestController	  // Anotacao para ser um web service e ter um endpoint, 
@RequestMapping(value = "/payments") // nome do recourso web que esta sendo disponibilizado
public class PaymentResource {

	@Autowired //Injetando paymentservice
	private PaymentService service;
	
	@GetMapping(value = "/{workerId}/days/{days}") // Endpoint rota
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){ // endpoint
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
}
