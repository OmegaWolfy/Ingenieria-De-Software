package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
	
	@Autowired
	EventoRepository eventorepository;


	
	public  List<Evento> getAll() {
		return eventorepository.findAll();
	}
	
	
	
	public Evento getById(long idevento) {
		return eventorepository.getOne(idevento);
	}
	

	public void add(Evento evento) {
		eventorepository.save(evento);
	}

	
	public void update(Evento evento) {
		Evento l = eventorepository.getOne(evento.getidevento());
		l.setLatitud(evento.getLatitud());
		l.setLongitud(evento.getLongitud());
		l.setDescripcion(evento.getDescripcion());
		l.setNombre(evento.getNombre());
		l.setImagen(evento.getImagen());
		eventorepository.saveAndFlush(l);
	}

	
	
	
	public void delete(long idevento) {
		eventorepository.deleteById(idevento);
	}

}
