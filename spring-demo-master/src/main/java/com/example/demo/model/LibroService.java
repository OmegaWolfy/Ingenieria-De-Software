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
	public void update(Evento Evento) {
		Evento l = repository.getOne(Evento.getidevento());
		l.setLatitud(Evento.getLatitud());
		l.setLongitud(Evento.getLongitud());
		l.setDescripcion(Evento.getDescripcion());
		l.setNombre(Evento.getNombre());
		l.setImagen(Evento.getImagen());
		repository.saveAndFlush(l);
	}

	public Evento getByIsbn13(long idEvento) {
		return repository.getOne(idEvento);
	}
	
	public Evento getByName(String name) {
		return repository.findByNombre(name);
	}

	public void add(Evento Evento) {
		repository.saveAndFlush(Evento);
	}

	public void delete(long idEvento) {
		repository.deleteById(idEvento);
	}

}
