package com.joseluis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name= "MEDICO")
public class Medico {
	@Id
	@Column(name="ID_MEDICO")
	@GeneratedValue(generator= "seq_Medico")
	@SequenceGenerator(name="seq_Medico", sequenceName = "SEQ_MEDICO", allocationSize= 1)
	private int idMedico;
	
	@Column(name= "NOMBRES", nullable = false, length = 70)
	private String nombres;
	
	@Column(name= "APELLIDOS", nullable = false, length = 70)
	private String apellidos;
	
	@Column(name= "CMP", nullable = false, length=12)
	private String CMP;

	public int getIdMedico() {
		return idMedico;
	}

	public Medico() {
		super();
	}

	public Medico(int idMedico, String nombres, String apellidos, String cMP) {
		super();
		this.idMedico = idMedico;
		this.nombres = nombres;
		this.apellidos = apellidos;
		CMP = cMP;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCMP() {
		return CMP;
	}

	public void setCMP(String cMP) {
		CMP = cMP;
	}

	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nombres=" + nombres + ", apellidos=" + apellidos + ", CMP=" + CMP
				+ "]";
	}
	
}
