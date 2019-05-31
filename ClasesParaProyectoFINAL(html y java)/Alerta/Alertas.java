package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alertas {
	@Id
	private String Trafico;

	private String Deportivos;
	private String Sociales;

	public alertas() {

	}

	public Persona(String Deportivos, String Sociales, String Trafico) {
		this.Deportivos = Deportivos;
		this.Sociales = Sociales;
		this.Trafico = Trafico;
	}

	public String getDeportivos() {
		return Deportivos;
	}

	public void setDeportivos(String Deportivos) {
		this.Deportivos = Deportivos;
	}

	public String getSociales() {
		return Sociales;
	}

	public void setSociales(String Sociales) {
		this.Sociales = Sociales;
	}

	public String getTrafico() {
		return Trafico;
	}

	public void setTrafico(String Trafico) {
		this.Trafico = Trafico;
	}

	@Override
	public String toString() {
		return "Se an seleccionado las alertas de:" + Trafico + ", " + Deportivos + ", " + Sociales + "";
	}

	public int hashCode() {
		try {
			return Integer.parseInt(Trafico);
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

		final Alertas other = (Alertas) obj;
		if (!Trafico.equals(other.getTrafico()))
			return false;
		return true;
	}

}
