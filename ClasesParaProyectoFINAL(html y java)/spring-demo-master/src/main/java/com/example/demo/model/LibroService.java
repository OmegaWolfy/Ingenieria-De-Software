package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
	/*---Interfaz para la gestion de datos de Libros---*/
	@Autowired
	LibroRepository repository;

	/*---Devuelve la lista de libros---*/
	public List<Evento> getAll() {
		return repository.findAll();
	}

	/*---Actualiza un libro---*/
	public void update(Evento evento) {
		Evento l = repository.getOne(evento.getidevento());
		l.setLatitud(evento.getLatitud());
		l.setLongitud(evento.getLongitud());
		l.setDescripcion(evento.getDescripcion());
		l.setNombre(evento.getNombre());
		l.setImagen(evento.getImagen());
		repository.saveAndFlush(l);
	}

	public Evento getByIsbn13(long idevento) {
		return repository.getOne(idevento);
	}
	
	public Evento getByName(String name) {
		return repository.findByNombre(name);
	}

	public void add(Evento Evento) {
		repository.saveAndFlush(Evento);
	}

	public void delete(long idevento) {
		repository.deleteById(idevento);
	}

}
