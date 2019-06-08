package com.joseluis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	@Id
	@Column(name="ID_USUARIO")
	@GeneratedValue(generator= "seq_Usuario")
	@SequenceGenerator(name="seq_Usuario", sequenceName = "SEQ_USUARIO", allocationSize= 1)
	private Integer idUsuario;
	
	@Column(name= "USUARIO", nullable = false, length = 70)
	private String usuario;
	
	@Column(name= "PASSWORD", nullable = false, length = 70)
	private String password;

	
	public Usuario(Integer idUsuario, String usuario, String password) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.password = password;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + "]";
	}
	
	
}
