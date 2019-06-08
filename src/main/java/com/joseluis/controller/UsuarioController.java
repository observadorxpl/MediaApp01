package com.joseluis.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.joseluis.model.Usuario;
import com.joseluis.service.IUsuarioService;
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService service;
	
	@PutMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<Integer> login(@RequestBody Usuario usuario) {
			int sw = 0;
			try {
				service.login(usuario.getUsuario(), usuario.getPassword());
				sw= 1;
			} catch (Exception e) {
				new ResponseEntity<Integer>(sw, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Integer>(sw, HttpStatus.OK);
		}
	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> lista = new ArrayList<>();
		try {
			lista =service.listar();
		} catch (Exception e) {
			new ResponseEntity<List<Usuario>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}
	
}
