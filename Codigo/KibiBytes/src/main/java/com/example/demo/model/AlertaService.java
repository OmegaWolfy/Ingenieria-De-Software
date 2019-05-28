package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

public class AlertaService {

	//Interfaz para el manejo de alertas
	@Autowired
	AlertaRepository alertaRepo;
	//activar alertas
	public boolean enableAlerts(boolean state) {
		state=true;
		return state;
	}
	//desactivar alertas
	public boolean disableAlerts(boolean state) {
		state=false;
		return state;
	}
	
	//anyadir un tipo de alerta
	public void add(Alerta a) {
		alertaRepo.save(a);
	}
	//quitar un tipo de alerta
	public void delete(Alerta a) {
		alertaRepo.delete(a);
	}
	
}
