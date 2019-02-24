package com.joseluis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "ESPECIALIDAD")
public class Especialidad {
	@Id
	@Column(name="ID_ESPECIALIDAD")
	@GeneratedValue(generator = "seq_Especialidad")
	@SequenceGenerator(name = "seq_Especialidad", sequenceName = "SEQ_ESPECIALIDAD", allocationSize= 1)
	private int idEspecialidad;
	
	@Column(name="NOMBRE", nullable= false, length= 70)
	private String nombre;

	
	public Especialidad() {
		super();
	}

	public Especialidad(int idEspecialidad, String nombre) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.nombre = nombre;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", nombre=" + nombre + "]";
	}
	
}
