package com.example.demo.model;

public class Alerta {

	private String notificacion;
	
	public Alerta(String n){
		notificacion=n;
	}
	
	public String getNotificacion() {
		return notificacion;
	}
	
	public String toString() {
		return "Tal vez le interesa: "+notificacion; 
	}
	
}
