package com.joseluis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EXAMEN")
public class Examen {
	@Id
	@Column(name = "ID_EXAMEN")
	@GeneratedValue(generator = "seq_Examen")
	@SequenceGenerator(name = "seq_Examen", sequenceName = "SEQ_EXAMEN", allocationSize= 1)
	private int idExamen;
	
	@Column(name = "NOMBRE", nullable = false, length = 250)
	private String nombre;
	
	@Column(name = "DESCRIPCION", nullable = false, length = 250)
	private String descripcion;

	
	
	

	public Examen() {
		super();
	}

	public Examen(int idExamen, String nombre, String descripcion) {
		super();
		this.idExamen = idExamen;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Examen [idExamen=" + idExamen + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
