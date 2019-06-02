package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Valoracion {
	@Id
	private String otros;

	private String evento;
	private String puntuacion;

	public Valoracion() {

	}

	public Valoracion(String evento, String puntuacion, String otros) {
		this.evento = evento;
		this.puntuacion = puntuacion;
		this.otros = otros;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	@Override
	public String toString() {
		return "Valoracion [otros=" + otros + ", evento=" + evento + ", puntuacion=" + puntuacion + "]";
	}

	public int hashCode() {
		try {
			return Integer.parseInt(otros);
		} catch (Exception er) {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		final Valoracion other = (Valoracion) obj;
		if (!otros.equals(other.getOtros()))
			return false;
		return true;
	}

}
