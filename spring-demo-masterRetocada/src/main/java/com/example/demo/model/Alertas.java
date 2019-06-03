package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Alertas {

	// clave primaria
	@Id
	private long idalertas;

	
	
	private String deportivos;
	private String trafico;
	private String sociales;
	



	public Alertas() {

	}

	public Alertas(long id,String dep,String soc,String tra) {
		this.deportivos=dep;
		this.trafico=tra;
		this.sociales=soc;
		this.idalertas=id;
	}
	public long getidevento() {
		return idalertas;
	}

	public void setidevento(long evento) {
		this.idalertas = evento;
	}



	public String getDep() {
		return deportivos;
	}

	public void setDep(String dep) {
		this.deportivos = dep;
	}

	public String getTr() {
		return trafico;
	}

	public void setTr(String tr) {
		this.trafico = tr;
	}

	public String getsc() {
		return sociales;
	}

	public void setsc(String sc) {
		this.sociales = sc;
	}

	public int hashCode() {
		try {
			return (int) idalertas;
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
		if (idalertas !=other.getidevento() || deportivos !=other.getDep()|| trafico !=other.getTr() || sociales !=other.getsc()) 
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Se han seleccionado las alertas de:" + trafico + ", " + deportivos + ", " + sociales + "";
	}

}