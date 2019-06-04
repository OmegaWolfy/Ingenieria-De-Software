package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Evento {

	// clave primaria
	
	@Id
	private long idevento;

	
	
	private String nombre;
	private String imagen;
	private String descripcion;
	private double latitud;
	private double longitud;
	



	public Evento() {

	}

	public Evento(long idevento,String img, String name, String desc, double lat, double lon) {
		this.nombre = name;
		this.descripcion = desc;
		this.imagen = img;
		this.latitud = lat;
		this.longitud = lon;
		this.idevento=idevento;
	}
	public long getidevento() {
		return idevento;
	}

	public void setidevento(long idevento) {
		this.idevento = idevento;
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
			return (int)(idevento);
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
		if (idevento !=other.getidevento() ||imagen != other.getImagen() || descripcion !=other.getDescripcion() || nombre !=other.getNombre()
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