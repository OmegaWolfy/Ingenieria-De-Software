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

//Controlador de los objetos Evento
@Controller
public class EventoController {

	@Autowired
	EventoService eventoService;

	/*---Devuelve el template de evento*/
	@GetMapping("/eventos")
	public String listEventsView(Model model) {
		model.addAttribute("eventos", eventoService.getAll());
		// devuelvo el template personas
		return "eventos";
	}

	/*---Devuelve el formulario para crear un evento---*/
	@GetMapping("/eventos/add")
	public String addEventView(Evento evento, Model model) {
		model.addAttribute("eventos", eventoService.getAll());
		model.addAttribute("evento", evento);
		return "addEvento";
	}

	/*---Devuelve el formulario para editar un evento---*/
	@GetMapping("/eventos/edit/{nombre}")
	public String editPersonView(@PathVariable("nombre") String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("evento", eventoService.getByNombre(nombre));
		return "updateEvento";
	}

	/*---Anade un nuevo evento al sistema---*/
	@PostMapping("/eventos")
	public String save(@Valid Evento evento, BindingResult result, Model model) {
		try {
			eventoService.add(evento);
			model.addAttribute("create", true);
		} catch (Exception er) {
			model.addAttribute("create", false);
		}
		return listEventsView(model);
	}

	/*---Actualiza un nuevo evento del sistema---*/
	@PostMapping("/eventos/update")
	public String update(@Valid Evento evento, Model model) {
		try {
			eventoService.update(evento);
			model.addAttribute("udpate", true);
		} catch (Exception er) {
			model.addAttribute("update", false);
		}
		return listEventsView(model);
	}

	/*---Elimina un evento a partir de su nombre---*/
	@DeleteMapping("/eventos/{nombre}")
	public String delete(@PathVariable("nombre") String nombre, Model model) {

		try {
			eventoService.delete(nombre);
			model.addAttribute("delete", true);
		} catch (Exception er) {
			model.addAttribute("delete", false);
		}
		return listEventsView(model);
	}

}