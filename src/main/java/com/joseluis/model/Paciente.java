package com.joseluis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTE")
public class Paciente {
	@Id
	@Column(name = "ID_PACIENTE")
	@GeneratedValue(generator="seq_Paciente") 
    @SequenceGenerator(name="seq_Paciente",sequenceName="SEQ_PACIENTE", allocationSize=1) 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaciente;
	@Column(name = "NOMBRES", nullable = false, length= 70)
	private String nombres;
	@Column(name = "APELLIDOS", nullable = false, length= 70)
	private String apellidos;
	@Column(name = "DNI", nullable = false, length= 8)
	private String dni;
	@Column(name = "DIRECCION", nullable = true, length= 150)
	private String direccion;
	@Column(name = "TELEFONO", nullable = false, length= 9)
	private String telefono;
	
	
	public Paciente() {
		super();
	}
	public Paciente(int idPaciente, String nombres, String apellidos, String dni, String direccion, String telefono) {
		super();
		this.idPaciente = idPaciente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni="
				+ dni + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	
	
}
