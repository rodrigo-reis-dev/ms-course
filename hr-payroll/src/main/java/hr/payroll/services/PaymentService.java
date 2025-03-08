package hr.payroll.services;

import org.springframework.stereotype.Service;

import hr.payroll.entities.Payment;

@Service // Registrando essa class como um component do spring, para ser injetado em
			// outras classes @Component or @Service
public class PaymentService {

	// metodo para instanciar um payment
	public Payment getPayment(long workId, int days) {
		Payment payment = new Payment("Rodrigo", 200.00, days);
		return payment;
	}

}
