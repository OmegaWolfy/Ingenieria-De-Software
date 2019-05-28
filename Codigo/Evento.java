package com.example.demo.model;



public class Evento {

	//clases primarias
	@OneToOne
	private String nombre;
	
	public String imagen;
	public String descripcion;
	@Id
	private int ubicacion;
	
	public Evento(String n,String i,String d,int u) {
		nombre=n;
		imagen=i;
		descripcion=d;
		ubicacion=u;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getUbicacion() {
		return ubicacion;
	}
	
	public void setNombre(String n) {
		nombre=n;
	}
	
	public void setImagen(String i) {
		imagen=i;
	}
	
	public void setDescripcion(String d) {
		descripcion=d;
	}
	
	public void setUbicacion(int u) {
		ubicacion=u;
	}
	
	public String toString() {
		return getNombre()+". Descripcion: "+getDescripcion();
	}
}
