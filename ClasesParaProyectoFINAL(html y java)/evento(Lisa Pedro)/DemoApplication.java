package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Evento;
import com.example.demo.model.EventoService;


@SpringBootApplication
public class DemoApplication {

	// JPA
	// https://www.objectdb.com/java/jpa/entity/id

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventoService eventoService) {
		return (args) -> {
			// crear datos al arrancar la aplicación
			// se usa para meter datos de prueba

			Evento libro1 = new Evento( "Introduccion a Spring","...","una bonica casa",420,360);
			eventoService.add(libro1);


			// ejemplo de como buscar por nombre
			Evento l1 = eventoService.getByName("Introduccion a Spring");
			Evento libroInexistente = eventoService.getByName("NONAME");
		};
	}

}
