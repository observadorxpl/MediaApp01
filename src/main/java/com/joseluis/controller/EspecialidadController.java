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

import com.joseluis.model.Especialidad;
import com.joseluis.service.EspecialidadServiceImpl;

@RequestMapping(value = "/especialidad")
@RestController
public class EspecialidadController {
	
	@Autowired
	private EspecialidadServiceImpl service;
@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Especialidad>> listar(){
	List<Especialidad> lista = new ArrayList<>();
	try {
		lista = service.listar();
	} catch (Exception e) {
		new ResponseEntity<List<Especialidad>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<List<Especialidad>>(lista, HttpStatus.OK);
	}

@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Especialidad > listarxId(@PathVariable("id") int id){
	Especialidad esp = new Especialidad();
	try {
		esp = service.listarId(id);
	} catch (Exception e) {
		new ResponseEntity<Especialidad>(esp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<Especialidad>(esp, HttpStatus.OK);
}
@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Especialidad> registrar(@RequestBody Especialidad especialidad){
		Especialidad esp = new Especialidad();
		try {
			esp = service.registrar(especialidad);
		} catch (Exception e) {
			new ResponseEntity<Especialidad>(esp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Especialidad>(esp, HttpStatus.OK);
	}
@PutMapping(value = "/modificar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> modificar(@RequestBody Especialidad especialidad){
		int sw = 0;
		try {
			service.modificar(especialidad);
			sw = 1;
		} catch (Exception e) {
			new ResponseEntity<Integer>(sw, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(sw, HttpStatus.OK);
	}
@DeleteMapping(value = "eliminar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable("id") int idEspecialidad){
		int sw = 0;
		try {
			service.eliminar(idEspecialidad);
			sw = 1;
		} catch (Exception e) {
			new ResponseEntity<Integer>(sw, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(sw, HttpStatus.OK);
	}
}
