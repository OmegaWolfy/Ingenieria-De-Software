package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Evento;
import com.example.demo.model.EventoService;

// Interfaz restful (No se usa en el frontend. Muestra como se implementaría servicios rest)
@RestController
public class EventoRestController {

	@Autowired
	EventoService eventoService;

	/*---Add new evento---*/
	@PostMapping("/evento")
	public ResponseEntity<?> save(@RequestBody Evento evento) {
		eventoService.add(evento);
		return ResponseEntity.ok().body("New evento has been saved");
	}

	/*---Get a evento by nombre---*/
	@GetMapping("/evento/{nombre}")
	public ResponseEntity<Evento> get(@PathVariable("nombre") String nombre) {
		Evento evento = eventoService.getByNombre(nombre);
		return ResponseEntity.ok().body(evento);
	}

	/*---get all eventos---*/
	@GetMapping("/evento")
	public ResponseEntity<List<Evento>> list() {
		List<Evento> eventos = eventoService.getAll();
		return ResponseEntity.ok().body(eventos);
	}

	/*---Update a evento by nombre---*/
	@PutMapping("/evento/{evento}")
	public ResponseEntity<?> update(@PathVariable("nombre") String nombre, @RequestBody Evento evento) {
		eventoService.update(evento);
		return ResponseEntity.ok().body("evento has been updated successfully.");
	}

	/*---Delete a evento by nombre---*/
	@DeleteMapping("/evento/{nombre}")
	public ResponseEntity<?> delete(@PathVariable("nombre") String nombre) {
		eventoService.delete(nombre);
		return ResponseEntity.ok().body("evento has been deleted successfully.");
	}
}
