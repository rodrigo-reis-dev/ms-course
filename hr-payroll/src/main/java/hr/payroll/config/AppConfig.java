package hr.payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// configuracao da aplicacao
@Configuration // Anotacao para dizer que eh uma classe de configuracao
public class AppConfig {

	// metodo que retorma um resttemplate, esse metodo serve para registrar uma instancia unica de um obj resttemplate,
	// essa instancia vai ficar disponivel para ser injetada em outros componentes
	@Bean // Anotacao para criar um componente apartir de um metodo, padrao Singleton
	public RestTemplate restTamplate() {
		return new RestTemplate();
	}
}
