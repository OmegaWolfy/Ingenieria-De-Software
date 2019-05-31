package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Evento {

	// clave primaria
	@Id
	

	private String evento;

	private String tipo_evento;



	public Evento() {

	}

	public Evento(String evento, String tipo_evento) {
		this.evento = evento;
		this.tipo_evento = tipo_evento;
	}

	public string getEvento() {
		return this.evento;
	}

	public string getTipo_evento() {
		return this.tipo_evento
	}

	

}