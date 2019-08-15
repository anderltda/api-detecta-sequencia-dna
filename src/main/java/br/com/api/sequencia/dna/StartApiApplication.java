package br.com.api.sequencia.dna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Anderson Nascimento
 *
 */
@EnableCaching
@SpringBootApplication
public class StartApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApiApplication.class, args);
	}

}
