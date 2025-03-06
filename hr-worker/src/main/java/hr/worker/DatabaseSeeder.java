package hr.worker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import hr.worker.entities.Worker;
import hr.worker.repositories.WorkerRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

	@Autowired
	private WorkerRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Worker w1 = new Worker(null, "Bob", 200.00);
		Worker w2 = new Worker(null, "Maria", 300.00);
		Worker w3 = new Worker(null, "Alex", 250.00);
		
		repo.saveAll(List.of(w1,w2,w3));
	}

}
