package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.model.Evento;
import com.example.demo.model.EventoService;
import com.example.demo.model.Persona;
import com.example.demo.model.PersonaService;

@SpringBootApplication

public class DemoApplication {

	// JPA
	// https://www.objectdb.com/java/jpa/entity/id

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventoService libroService, PersonaService personaService) {
		return (args) -> {
			// crear datos al arrancar la aplicación
			// se usa para meter datos de prueba
			Persona alice = new Persona("Alice", "Wonderland", "666");
			Persona ali = new Persona("Ali", "Baba", "777");
			personaService.add(alice);
			personaService.add(ali);

			Evento libro1 = new Evento( 1122l,"...","hola","una bonica casa",420,360);
			
			libroService.add(libro1);
			

		};
	}

}
