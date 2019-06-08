package com.joseluis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.joseluis.dao.IUsuarioDAO;
import com.joseluis.model.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioDAO dao;

	@Override
	public Usuario registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int idUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario listarId(int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		System.out.println(dao.findAll());	
		return dao.findAll();
	}

	@Override
	public int login(String usuario, String password) {
		int i = 0;
		try {
		//dao.login(usuario, password);
		return 1;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return 0;
		
	}
}
