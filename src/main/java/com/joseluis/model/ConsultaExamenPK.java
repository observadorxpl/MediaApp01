package com.joseluis.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//Anotacion para indicar que es una clase embedida
@Embeddable
public class ConsultaExamenPK  implements Serializable{

	private static final long serialVersionUID = 1L;

	/*
	 * CLASE ESPECIAL PARA LLAVES PRIMARIAS COMPUESTAS, 
	 * SI SE DESEA GENERAR LLAVES PRIMARIAS COMPUESTAS 
	 * ES IMPORTANTE LOS METODOS EQUALS AND HASCODE
	 */
	@ManyToOne
	@JoinColumn(name="ID_CONSULTA", nullable = false)
	private Consulta consulta;

	@ManyToOne
	@JoinColumn(name="ID_EXAMEN" , nullable = false)
	private Examen examen;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaExamenPK other = (ConsultaExamenPK) obj;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		return true;
	}
	
	
}
