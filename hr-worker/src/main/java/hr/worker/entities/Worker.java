package hr.worker.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Mapamento JPA, para ser mapado para uma tabela em um bd relacional
// Importa o "jakarta" que eh a interface, o hibernate eh a implementacao dessa interface
// sempre se programa com a interface, nao quem a implementacao

@Entity // Anotacao que diz que essa classe vai ser monitoriada pelo JPA
@Table(name = "tb_worker") // Anotacao para mudar a criacao da tabela de Worker para tb_worker
public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id // Anotacao para dizer que essa prop vai ser a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Anotacao que diz, para o bd gerar automaticamente o id
	private Long id;
	private String name;
	private Double dailyIncome;
	
	public Worker() {
		
	}

	public Worker(Long id, String name, Double dailyIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
