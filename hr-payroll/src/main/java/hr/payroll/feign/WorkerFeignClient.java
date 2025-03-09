package hr.payroll.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hr.payroll.entities.Worker;

@Component // Anotacao dizendo que essa classe eh um component gerenciado pelo Spring, para
			// injetar ele em outras classes
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {
	
	@GetMapping(value = "/{id}") // anotacao para pegar por id
	public ResponseEntity<Worker> findById(@PathVariable Long id);
}
