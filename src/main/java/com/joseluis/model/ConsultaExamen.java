package com.joseluis.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "CONSULTA_EXAMEN")

//Anotacion para llaves primarias compuestas
// 		 Clase que representa ID_CONSLTA Y ID_EXAMEN
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Consulta consulta;
	@Id
	private Examen examen;
	
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public Examen getExamen() {
		return examen;
	}
	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	
	
}
