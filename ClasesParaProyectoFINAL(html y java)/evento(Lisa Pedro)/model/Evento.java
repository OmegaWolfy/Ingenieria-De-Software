package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Evento {



	private String nombre;
	private String descripcion;

	
	private String imagen;

	@OneToOne
	private double latitud;
	@OneToOne
	private double longitud;
	public Evento() {

	}

	public Evento(String img, String name, String desc, double lat, double lon) {
		this.nombre = name;
		this.descripcion = desc;
		this.imagen = img;
		this.latitud = lat;
		this.longitud = lon;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double l) {
		this.latitud = l;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double l) {
		this.longitud = l;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String img) {
		this.imagen = img;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}

	public int hashCode() {
		try {
			return nombre.hashCode();
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

		final Evento other = (Evento) obj;
		if (imagen != other.getImagen() || descripcion !=other.getDescripcion() || nombre !=other.getNombre()
				|| latitud !=other.getLatitud() || longitud !=other.getLongitud()) 
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Evento [nombre=" + nombre + ", Descripcion: " + descripcion + ",\n " + imagen + ", latitud=" + latitud
				+ ", longitud=" + longitud + "]";
	}

}