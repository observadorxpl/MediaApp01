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

import com.joseluis.model.Examen;
import com.joseluis.service.IExamenService;
@RestController
@RequestMapping(value = "/examen")
public class ExamenController {
	@Autowired
	private IExamenService service;
	
	@GetMapping(value= "/listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Examen>> listar(){
		List<Examen> lista = new ArrayList<>();
		try {
			lista =service.listar();
		} catch (Exception e) {
			new ResponseEntity<List<Examen>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Examen>>(lista, HttpStatus.OK);
	}
	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Examen> listarxId(@PathVariable("id") int idExamen){
		Examen exa = new Examen();
		try {
			exa = service.listarId(idExamen);
		} catch (Exception e) {
			new ResponseEntity<Examen>(exa, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Examen>(exa, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<Examen> registrar (@RequestBody Examen examen) {
			Examen exa = new Examen();
			try {
				exa = service.registrar(examen);
			} catch (Exception e) {
				new ResponseEntity<Examen>(exa, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Examen>(exa, HttpStatus.OK);
		}

	@PutMapping(value = "/modificar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<Integer> modificar(@RequestBody Examen examen) {
			int sw = 0;
			try {
				service.modificar(examen);
				sw= 1;
			} catch (Exception e) {
				new ResponseEntity<Integer>(sw, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Integer>(sw, HttpStatus.OK);
		}
	@DeleteMapping(value= "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable("id") int idExamen){
		int sw = 0;
		try {
			service.eliminar(idExamen);
			sw= 1;
		} catch (Exception e) {
			new ResponseEntity<Integer>(sw, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(sw, HttpStatus.OK);
	}
}
