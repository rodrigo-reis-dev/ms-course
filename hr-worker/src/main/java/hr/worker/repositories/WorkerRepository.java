// Repository eh o obj que vai fazer acesso ao BD

package hr.worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.worker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
