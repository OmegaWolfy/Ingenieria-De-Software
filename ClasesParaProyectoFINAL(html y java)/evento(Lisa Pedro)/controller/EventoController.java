package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Evento;
import com.example.demo.model.EventoService;

// Controlador de los objetos Evento
@Controller
public class EventoController {

	@Autowired
	EventoService eventoService;

	/*---Devuelve el template HTML de libros---*/
	// petición recibida por get
	@GetMapping("/eventos")
	public String listEventView(Model model) {
		// datos que seran accesibles desde la plantilla (frontend)
		model.addAttribute("eventos", eventoService.getAll());
		// devuelvo el template libros
		return "eventos";
	}

	/*---Devuelve el formulario para crear un libro---*/
	@GetMapping("/eventos/add")
	public String addEventoView(Evento evento, Model model) {
		model.addAttribute("evento", evento);
		return "addEvento";
	}

	/*---Devuelve el formulario para editar un libro---*/
	@GetMapping("/eventos/edit/{nombre}")
	public String editEventoView(@PathVariable("nombre") String nombre, Model model) {

		model.addAttribute("evento", eventoService.getByName(nombre));
		return "updateEvento";
	}

	/*---Anade un nuevo libro al sistema y vuelve a la pantalla de consulta de libros---*/
	// petición recibida por post
	@PostMapping("/eventos")
	public String save(@Valid Evento evento, BindingResult result, Model model) {
		try {
			eventoService.add(evento);
			model.addAttribute("create", true);
		} catch (Exception er) {
			model.addAttribute("create", false);
		}
		return listEventView(model);
	}

	/*---Actualiza un libro del sistema y vuelve a la pantalla de consulta de libros---*/
	// petición recibida por post
	@PostMapping("/eventos/update")
	public String update(@Valid Evento evento, Model model) {
		try {
			eventoService.add(evento);
			model.addAttribute("udpate", true);
		} catch (Exception er) {
			model.addAttribute("update", false);
		}
		return listEventView(model);
	}

	/*---Elimina un libro a partir de su ISBN y vuelve a la pantalla de consulta de libros---*/
	// petición recibida por delete
	@DeleteMapping("/eventos/{nombre}")
	public String delete(@PathVariable("nombre") String nombre, Model model) {
		try {
			eventoService.delete(nombre);
			model.addAttribute("delete", true);
		} catch (Exception er) {
			model.addAttribute("delete", false);
		}
		return listEventView(model);
	}

}
