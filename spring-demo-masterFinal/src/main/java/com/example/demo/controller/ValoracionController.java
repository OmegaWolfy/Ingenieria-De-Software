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

import com.example.demo.model.Valoracion;
import com.example.demo.model.ValoracionService;

//Controlador de los objetos Persona
@Controller
public class ValoracionController {

	@Autowired
	ValoracionService valoracionService;

	/*---Devuelve el template de personas---*/
	@GetMapping("/valoracion")
	public String listPersonView(Model model) {
		model.addAttribute("valoracion", valoracionService.getAll());
		// devuelvo el template personas
		return "valoracion";
	}

	/*---Devuelve el formulario para crear una persona---*/
	@GetMapping("/valoracion/add")
	public String addValoracionView(Valoracion valoracion, Model model) {
		model.addAttribute("valoracion", valoracionService.getAll());
		model.addAttribute("valoracion", valoracion);
		return "addValoracion";
	}

	/*---Devuelve el formulario para editar una persona---*/
	@GetMapping("/valoracion/edit/{id}")
	public String editPersonView(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("valoracion", valoracionService.getByOtros(id));
		return "updateValoracion";
	}

	/*---Anade una nueva persona al sistema---*/
	@PostMapping("/valoracion")
	public String save(@Valid Valoracion valoracion, BindingResult result, Model model) {
		try {
			valoracionService.add(valoracion);
			model.addAttribute("create", true);
		} catch (Exception er) {
			model.addAttribute("create", false);
		}
		return listPersonView(model);
	}

	/*---Actualiza una nueva persona del sistema---*/
	@PostMapping("/valoracion/update")
	public String update(@Valid Valoracion valoracion, Model model) {
		try {
			valoracionService.update(valoracion);
			model.addAttribute("udpate", true);
		} catch (Exception er) {
			model.addAttribute("update", false);
		}
		return listPersonView(model);
	}

	/*---Elimina una persona a partir de su DNI---*/
	@DeleteMapping("/valoracion/{id}")
	public String delete(@PathVariable("id") String id, Model model) {

		try {
			valoracionService.delete(id);
			model.addAttribute("delete", true);
		} catch (Exception er) {
			model.addAttribute("delete", false);
		}
		return listPersonView(model);
	}

}
