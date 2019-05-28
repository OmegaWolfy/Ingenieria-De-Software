package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Usuario { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String clave; 
	public String user; 
	private String mail;
	 
	public Usuario(String u,String c, String m, long i){ 
		user=u; 
		clave=c; 
		mail=m;
		id=i;
	} 
	 
	public String getUser() { 
		return user; 
	} 
	 
	public String getPass() { 
		return clave; 
	} 
	
	public String getMail() {
		return mail;
	}
	
	public long getId() {
		return id;
	}
	
	public void setUser(String u) {
		user=u;
	}
	
	public void setPass(String c) {
		clave=c;
	}
	
	public void setMail(String m) {
		mail=m;
	}
	
	public String toString() { 
		return user+ " , "+clave; 
	} 
} 