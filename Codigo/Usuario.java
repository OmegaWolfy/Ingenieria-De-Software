package com.example.demo.model;

public class Usuario { 
	 
	private String clave; 
	public String user; 
	private String mail;
	 
	public Usuario(String u,String c, String m){ 
		user=u; 
		clave=c; 
		mail=m;
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
