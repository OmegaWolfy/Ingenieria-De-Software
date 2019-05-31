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

import com.example.demo.model.Persona;
import com.example.demo.model.alertaservice;

//Controlador de los objetos Persona
@Controller
public class PersonaController {

	@Autowired
	alertaservice alertaservice;

	/*---Devuelve el template de alertas---*/
	@GetMapping("/alertas")
	public String listPersonView(Model model) {
		model.addAttribute("alertas", alertaservice.getAll());
		// devuelvo el template alertas
		return "alertas";
	}

	/*---Devuelve el formulario para crear una persona---*/
	@GetMapping("/alertas/add")
	public String addPersonView(Alertas alertas /*Persona persona*/, Model model) {
		model.addAttribute("alertas", alertaservice.getAll());
		//model.addAttribute("persona", persona);
		return "addPersona";
	}

	/*---Devuelve el formulario para editar una persona---*/
	@GetMapping("/alertas/edit/{id}")
	public String editPersonView(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		//model.addAttribute("persona", alertaservice.getByDni(id));
		return "updatePersona";
	}

	/*---Anade una nueva persona al sistema---*/
	@PostMapping("/alertas")
	public String save(@Valid Alertas alertas /*Persona persona*/, BindingResult result, Model model) {
		try {
			alertaservice.add(alertas/*persona*/);
			model.addAttribute("create", true);
		} catch (Exception er) {
			model.addAttribute("create", false);
		}
		return listPersonView(model);
	}

	/*---Actualiza una nueva persona del sistema---*/
	@PostMapping("/alertas/update")
	public String update(@Valid Alertas alertas /*Persona persona*/, Model model) {
		try {
			alertaservice.update(alertas/*persona*/);
			model.addAttribute("udpate", true);
		} catch (Exception er) {
			model.addAttribute("update", false);
		}
		return listPersonView(model);
	}

	/*---Elimina una persona a partir de su DNI---*/
	@DeleteMapping("/alertas/{id}")
	public String delete(@PathVariable("id") String id, Model model) {

		try {
			alertaservice.delete(id);
			model.addAttribute("delete", true);
		} catch (Exception er) {
			model.addAttribute("delete", false);
		}
		return listPersonView(model);
	}

}
