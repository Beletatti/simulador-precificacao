package io.github.simulador.simulador_precificacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SimuladorPrecificacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimuladorPrecificacaoApplication.class, args);
	}

}
