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

import com.joseluis.model.Medico;
import com.joseluis.service.IMedicoService;

@RequestMapping(value= "/medico")
@RestController
public class MedicoController {
	@Autowired
	private IMedicoService service;

@GetMapping(value= "/listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Medico>> listar(){
		List<Medico> lista = new ArrayList<>();
		try {
			lista =service.listar();
		} catch (Exception e) {
			new ResponseEntity<List<Medico>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Medico>>(lista, HttpStatus.OK);
	}
@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Medico> listarxId(@PathVariable("id") int idMedico){
	Medico med = new Medico();
	try {
		med = service.listarId(idMedico);
	} catch (Exception e) {
		new ResponseEntity<Medico>(med, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<Medico>(med, HttpStatus.OK);
}

@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Medico> registrar (@RequestBody Medico medico) {
		Medico med = new Medico();
		try {
			med = service.registrar(medico);
		} catch (Exception e) {
			new ResponseEntity<Medico>(med, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Medico>(med, HttpStatus.OK);
	}

@PutMapping(value = "/modificar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> modificar(@RequestBody Medico medico) {
		int sw = 0;
		try {
			service.modificar(medico);
			sw= 1;
		} catch (Exception e) {
			new ResponseEntity<Integer>(sw, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(sw, HttpStatus.OK);
	}
@DeleteMapping(value= "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Integer> eliminar(@PathVariable("id") int idMedico){
	int sw = 0;
	try {
		service.eliminar(idMedico);
		sw= 1;
	} catch (Exception e) {
		new ResponseEntity<Integer>(sw, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<Integer>(sw, HttpStatus.OK);
}
}
