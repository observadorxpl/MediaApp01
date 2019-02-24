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

import com.joseluis.model.Paciente;
import com.joseluis.service.IPacienteService;

@RestController
@RequestMapping(value= "/paciente")
public class PacienteController {
	@Autowired
	private IPacienteService service;
	
@GetMapping(value="/listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity <List<Paciente>> listar(){
		List<Paciente> lista = new ArrayList<>();
		try {
			lista = service.listar();
			System.out.println(lista);
		} catch (Exception e) {
			new ResponseEntity <List<Paciente>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}

@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
		Paciente per = new Paciente();
		try {
			per = service.registrar(paciente);
		} catch (Exception e) {
			new ResponseEntity<Paciente>(per, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Paciente>(per, HttpStatus.OK);
	}

@PutMapping(value = "/modificar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Paciente paciente) {
		int sw = 0;
		try {
			service.modificar(paciente);
			System.out.println(paciente);
			sw = 1;
		} catch (Exception e) {
			new ResponseEntity<Integer>(sw, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(sw, HttpStatus.OK);
	} 
	

@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Integer> eliminar(@PathVariable("id") int idPaciente) {
	int sw = 0;
	try {
		service.eliminar(idPaciente);
		sw= 1;
	} catch (Exception e) {
		new ResponseEntity<Integer>(sw, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<Integer>(sw, HttpStatus.OK);
}
@GetMapping(value= "/listar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Paciente> listarxId(@PathVariable("id") int id) {
		Paciente paciente = new Paciente();
		try {
			paciente = service.listarId(id);
		} catch (Exception e) {
			new ResponseEntity<Paciente>(paciente, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
	}
	
}
