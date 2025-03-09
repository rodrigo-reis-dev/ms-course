package hr.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.payroll.entities.Payment;
import hr.payroll.entities.Worker;
import hr.payroll.feign.WorkerFeignClient;

@Service // Registrando essa class como um component do spring, para ser injetado em
			// outras classes @Component or @Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeign;

	// metodo para instanciar um payment
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeign.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);

	}

}
