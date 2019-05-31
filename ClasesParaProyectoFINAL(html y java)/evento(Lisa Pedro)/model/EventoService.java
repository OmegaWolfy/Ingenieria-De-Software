package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
	/*---Interfaz para la gestion de datos de Libros---*/
	@Autowired
	EventoRepository repository;

	/*---Devuelve la lista de eventos---*/
	public List<Evento> getAll() {
		return repository.findAll();
	}

	/*---Actualiza un evento---*/
	public void update(Evento libro) {
		Evento l = repository.getOne(libro.getNombre());
		l.setLatitud(libro.getLatitud());
		l.setLongitud(libro.getLongitud());
		l.setDescripcion(libro.getDescripcion());
		l.setImagen(libro.getImagen());
		repository.saveAndFlush(l);
	}

	
	public Evento getByName(String name) {
		return repository.findByNombre(name);
	}

	public void add(Evento evento) {
		repository.saveAndFlush(evento);
	}

	public void delete(String nombre) {
		repository.delete(nombre);
	}

}
