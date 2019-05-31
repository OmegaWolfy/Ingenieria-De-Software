package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class alertaservice {
	
	/*---Interfaz para la gestion de datos de alertas---*/
	@Autowired
	AlertasRepository AlertasRepository;

	
	public List<alerta> getAll() {
		return AlertasRepository.findAll();
	}
		
	public Alertas getByTrafico(String Trafico) {
		return AlertasRepository.getOne(Trafico);
	}
	
	public void add(Alertas alertas) {
		AlertasRepository.save(alertas);
	}
	
	public void update(Alertas alertas) {
		alertas p = AlertasRepository.getOne(Alertas.getTrafico());
		p.setDeportivos(Alertas.getDeportivos());
		p.setSociales(Alertas.getSociales());
		AlertasRepository.saveAndFlush(p);
	}
	
	public void delete(String Trafico) {
		AlertasRepository.deleteById(Trafico);
	}
	
}
