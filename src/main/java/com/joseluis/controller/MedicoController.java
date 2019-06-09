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

import com.joseluis.model.Medico;
import com.joseluis.service.IMedicoService;

@RequestMapping(value = "/medicos")
@RestController
public class MedicoController {
	@Autowired
	private IMedicoService service;

	@GetMapping
	public ResponseEntity<List<Medico>> listar() {
		List<Medico> lista = new ArrayList<>();
		try {
			lista = service.listar();
		} catch (Exception e) {
			new ResponseEntity<List<Medico>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Medico>>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Medico> listarxId(@PathVariable("id") int idMedico) {
		Medico med = new Medico();
		try {
			med = service.listarId(idMedico);
		} catch (Exception e) {
			new ResponseEntity<Medico>(med, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Medico>(med, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Medico> registrar(@RequestBody Medico medico) {
		Medico med = new Medico();
		try {
			med = service.registrar(medico);
		} catch (Exception e) {
			new ResponseEntity<Medico>(med, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Medico>(med, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Medico> modificar(@RequestBody Medico medico) {
		Medico med = new Medico();
		try {
			med = service.modificar(medico);
		} catch (Exception e) {
			new ResponseEntity<Medico>(med, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Medico>(med, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") int idMedico) {
			service.eliminar(idMedico);
	}
}
