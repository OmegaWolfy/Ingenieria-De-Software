package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
	
	/*---Interfaz para la gestion de datos de Personas---*/
	@Autowired
	EventoRepository eventoRepository;

	
	public List<Evento> getAll() {
		return eventoRepository.findAll();
	}
	
	public void add(Evento evento) {
		eventoRepository.save(evento);
	}
	
	public void update(Evento evento) {
		Evento e = eventoRepository.getOne(evento.getNombre());
		e.setDescripcion(evento.getDescripcion());
		e.setNombre(evento.getNombre());
		e.setImagen(evento.getImagen());
		e.setUbicacion(evento.getUbicacion());
		eventoRepository.saveAndFlush(e);
	}
	
	public void delete(String nombre) {
		eventoRepository.deleteByName(nombre);
	}

	public Evento getByNombre(String nombre) {
		Evento e=eventoRepository.FindByNombre(nombre);
		
		return e;
	}
}