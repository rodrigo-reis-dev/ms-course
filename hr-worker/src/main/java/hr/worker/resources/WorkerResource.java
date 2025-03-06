package hr.worker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.worker.entities.Worker;
import hr.worker.repositories.WorkerRepository;

// Resource eh um recurso web, que disponibiliza na internet os endpoint


@RestController // Anotacao para que essa classe seja para ser endpoint
@RequestMapping(value = "/workers") // Anotacao que diz qual o caminho para esse recurso
public class WorkerResource {

	// endpoint para retornar todos os workers
	@Autowired // anotacao para o spring fazer automaticamente a injecao de dependencia
	private WorkerRepository repo; // injecao de dependica do workerrepo, eh o obj que acessa o bd
	
	// Metodo para retornar uma resposta http
	@GetMapping // Anotacao para funcionar, sem argumento, que pega todos
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list; // Instanciar uma lista do tipo Worker com os objs que estao no bd
		list = repo.findAll();// Essa lista vai receber o repo, que eh o objeto que faz o acesso ao bd, o repo tem varios metodos
		return ResponseEntity.ok(list); // Retorna o tipo do metado, .ok diz que foi com sucesso, e no corpo, vai a lista
	}
	
	@GetMapping(value = "/{id}") // anotacao para pegar por id
	public ResponseEntity<Worker> findById(@PathVariable Long id){ // metodo do tipo Worker, que recebe um id como parametro, a anotacao serve para o id seja reconhecido na requisicao
		Worker worker = repo.findById(id).get(); // findByID retonar um Optional, tem que usar o get para pegar o id do Optinal
		return ResponseEntity.ok(worker);
	}
	
}
