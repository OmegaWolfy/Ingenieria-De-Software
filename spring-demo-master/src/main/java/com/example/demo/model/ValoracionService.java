package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValoracionService {
	
	
	@Autowired
	ValoracionRepository valoracionRepository;

	
	public List<Valoracion> getAll() {
		return valoracionRepository.findAll();
	}
		
	public Valoracion getByOtros(String otros) {
		return valoracionRepository.getOne(otros);
	}
	
	public void add(Valoracion valoracion) {
		valoracionRepository.save(valoracion);
	}
	
	public void update(Valoracion valoracion) {
		Valoracion p = valoracionRepository.getOne(valoracion.getOtros());
		p.setPuntuacion(valoracion.getPuntuacion());
		p.setEvento(valoracion.getEvento());
		valoracionRepository.saveAndFlush(p);
	}
	
	public void delete(String otros) {
		valoracionRepository.deleteById(otros);
	}
	
}
