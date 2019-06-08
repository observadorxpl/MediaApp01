package com.joseluis.service;

import java.util.List;

import com.joseluis.model.Usuario;

public interface IUsuarioService {
	Usuario registrar(Usuario usuario);
	void modificar(Usuario usuario);
	void eliminar(int idUsuario);
	Usuario listarId(int idUsuario);
	List<Usuario> listar();
	int login(String usuario, String password);
}
