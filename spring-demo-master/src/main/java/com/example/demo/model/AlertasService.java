package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertasService {
	
	/*---Interfaz para la gestion de datos de alertas---*/
	@Autowired
	AlertasRepository repository;

	
	public List<Alertas> getAll() {
		return repository.findAll();
	}
		
	public void update(Alertas alertas) {
		Alertas p = repository.findBytrafico(alertas.getTr());
		p.setDep(alertas.getDep());
		p.setsc(alertas.getsc());
		repository.saveAndFlush(p);
	}
	
	

	
	public Alertas getByAlertas(String Alertas) {
		return repository.findBytrafico(Alertas);
	}
	

	
	public void add(Alertas alertas) {
		repository.saveAndFlush(alertas);
	}
	
	
	public void delete(String Alertas) {
		repository.deleteById(Alertas);
	}

	
	
	
}
