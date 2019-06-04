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

import com.example.demo.model.Alertas;
import com.example.demo.model.AlertasService;


//Controlador de los objetos Persona
@Controller
public class AlertasController {

	@Autowired
	AlertasService alertaservice;

	/*---Devuelve el template de alertas---*/
	@GetMapping("/Alertas")
	public String ListaAlertas(Model model) {
		model.addAttribute("alertas", alertaservice.getAll());
		// devuelvo el template alertas
		return "alertas";
	}

	/*---Devuelve el formulario para crear una persona---*/
	@GetMapping("/Alertas/add")
	public String addPersonView(Alertas alertas , Model model) {
		model.addAttribute("alertas", alertaservice.getAll());
		
		return "AlertasCreadas";
	}

	/*---Devuelve el formulario para editar una persona---*/
	@GetMapping("/Alertas/edit/{alertas}")
	public String editPersonView(@PathVariable("alertas") String alertas, Model model) {
		model.addAttribute("alertas",alertaservice.getByAlertas(alertas));
	
		return "updateAlertas";
	}

	/*---Anade una nueva persona al sistema---*/
	@PostMapping("/Alertas")
	public String save(@Valid Alertas alertas , BindingResult result, Model model) {
		try {
			alertaservice.add(alertas);
			model.addAttribute("create", true);
		} catch (Exception er) {
			model.addAttribute("create", false);
		}
		return ListaAlertas(model);
	}

	/*---Actualiza una nueva persona del sistema---*/
	@PostMapping("/Alertas/update")
	public String update(@Valid Alertas alertas, Model model) {
		try {
			alertaservice.update(alertas);
			model.addAttribute("udpate", true);
		} catch (Exception er) {
			model.addAttribute("update", false);
		}
		return ListaAlertas(model);
	}

	/*---Elimina una persona a partir de su DNI---*/
	@DeleteMapping("/Alertas/{alertas}")
	public String delete(@PathVariable("alertas") String Alertas, Model model) {

		try {
			alertaservice.delete(Alertas);
			model.addAttribute("delete", true);
		} catch (Exception er) {
			model.addAttribute("delete", false);
		}
		return ListaAlertas(model);
	}

}
