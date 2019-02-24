package com.joseluis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name= "DETALLECONSULTA")
public class DetalleConsulta {
	@Id
	@Column(name= "ID_DETALLECONSULTA")
	@GeneratedValue(generator= "seq_DetalleConsulta")
	@SequenceGenerator(name="seq_DetalleConsulta", sequenceName = "SEQ_DETALLECONSULTA", allocationSize= 1)
	private int idDetalle;
	
	@ManyToOne
	@JoinColumn(name= "ID_CONSULTA")
	@JsonIgnore
	private Consulta consulta;
	
	@Column(name= "DIAGNOSTICO", nullable = false, length = 250)
	private String diagnostico;
	
	@Column(name= "TRATAMIENTO", nullable = false, length = 250)
	private String tratamiento;
	
	
	public DetalleConsulta() {
		super();
	}
	public DetalleConsulta(int idDetalle, Consulta consulta, String diagnostico, String tratamiento) {
		super();
		this.idDetalle = idDetalle;
		this.consulta = consulta;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
	}
	public int getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	@Override
	public String toString() {
		return "DetalleConsulta [idDetalle=" + idDetalle + ", consulta=" + consulta + ", diagnostico=" + diagnostico
				+ ", tratamiento=" + tratamiento + "]";
	}
	
	
}
