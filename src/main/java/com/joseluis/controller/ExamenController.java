package com.joseluis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

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
@RequestMapping(value = "/examenes")
public class ExamenController {
	@Autowired
	private IExamenService service;

	@GetMapping
	public ResponseEntity<List<Examen>> listar() {
		List<Examen> lista = new ArrayList<>();
		try {
			lista = service.listar();
		} catch (Exception e) {
			new ResponseEntity<List<Examen>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Examen>>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Examen> listarxId(@PathVariable("id") int idExamen) {
		Examen exa = new Examen();
		try {
			exa = service.listarId(idExamen);
		} catch (Exception e) {
			new ResponseEntity<Examen>(exa, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Examen>(exa, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Examen> registrar(@RequestBody Examen examen) {
		Examen exa = new Examen();
		try {
			exa = service.registrar(examen);
		} catch (Exception e) {
			new ResponseEntity<Examen>(exa, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Examen>(exa, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Examen> modificar(@RequestBody Examen examen) {
		Examen ex = new Examen();
		try {
			ex = service.modificar(examen);
		} catch (Exception e) {
			new ResponseEntity<Examen>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Examen>(ex, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") int idExamen) {
		service.eliminar(idExamen);
	}
}
