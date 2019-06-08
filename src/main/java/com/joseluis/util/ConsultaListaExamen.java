package com.joseluis.util;

import java.io.Serializable;
import java.util.List;

import com.joseluis.model.Consulta;
import com.joseluis.model.Examen;
//CLASE DTO QUE AYUDA A LAS CONSULTAS PERSONALIZADAS
// SE DEBE IMPLEMENTAR SERIALIZABLE
public class ConsultaListaExamen implements Serializable {
	private Consulta consulta;
	private List<Examen> examenes;
	
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public List<Examen> getExamenes() {
		return examenes;
	}
	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}
	
	
}
