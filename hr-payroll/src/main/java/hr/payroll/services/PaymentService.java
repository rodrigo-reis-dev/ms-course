package hr.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hr.payroll.entities.Payment;
import hr.payroll.entities.Worker;

@Service // Registrando essa class como um component do spring, para ser injetado em
			// outras classes @Component or @Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	// injetando uma instancia de resttemplate
	@Autowired // Anotacao para auto injetar
	public RestTemplate restTemplate;

	// metodo para instanciar um payment
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", "" + workerId);

		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), days);
		return payment;
	}

}
