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

//Controlador de los objetos Persona
@Controller
public class EventoController {

	@Autowired
	EventoService eventoService;

	/*---Devuelve el template de personas---*/
	@GetMapping("/Evento")
	public String listEvento(Model model) {
		model.addAttribute("Evento", eventoService.getAll());
		// devuelvo el template personas
		return "Evento";
	}


}
