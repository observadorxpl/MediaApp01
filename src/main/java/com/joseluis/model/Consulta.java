package com.joseluis.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
@Entity
@Table(name= "CONSULTA")
public class Consulta implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@Column(name= "ID_CONSULTA")
	@GeneratedValue(generator= "seq_Consulta")
	@SequenceGenerator(name="seq_Consulta", sequenceName = "SEQ_CONSULTA", allocationSize= 1)
	private int idConsulta;
	

	@ManyToOne
	@JoinColumn(name = "ID_PACIENTE")
	private Paciente paciente;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha;
	//aaaa-MM-dd-HH-mm-ss.zzz
	

	@ManyToOne
	@JoinColumn(name= "ID_ESPECIALIDAD")
	private Especialidad especialidad;
	

	@ManyToOne
	@JoinColumn(name= "ID_MEDICO")
	private Medico medico;
	
	
	// LAZY = Permite tener un mejor rendimiento. La consulta JPQL.
	// OrphanRemoval = Permite remover un elemento de la lista de la BD
	@OneToMany(mappedBy= "consulta", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetalleConsulta> detalleConsulta;


	
	
	
	public Consulta() {
		super();
	}


	public Consulta(int idConsulta, Paciente paciente, LocalDateTime fecha, Especialidad especialidad, Medico medico,
			List<DetalleConsulta> detalleConsulta) {
		super();
		this.idConsulta = idConsulta;
		this.paciente = paciente;
		this.fecha = fecha;
		this.especialidad = especialidad;
		this.medico = medico;
		this.detalleConsulta = detalleConsulta;
	}


	public int getIdConsulta() {
		return idConsulta;
	}


	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}


	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}


	@Override
	public String toString() {
		return "Consulta [idConsulta=" + idConsulta + ", paciente=" + paciente + ", fecha=" + fecha + ", especialidad="
				+ especialidad + ", medico=" + medico + ", detalleConsulta=" + detalleConsulta + "]";
	}
	
	
}
