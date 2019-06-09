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

import com.joseluis.model.Paciente;
import com.joseluis.service.IPacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
	@Autowired
	private IPacienteService service;

	@GetMapping
	public ResponseEntity<List<Paciente>> listar() {
		List<Paciente> lista = new ArrayList<>();
		try {
			lista = service.listar();
		} catch (Exception e) {
			new ResponseEntity<List<Paciente>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
		Paciente pac = new Paciente();
		try {
			pac = service.registrar(paciente);
		} catch (Exception e) {
			new ResponseEntity<Paciente>(pac, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Paciente>(pac, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
		Paciente pac = new Paciente();
		try {
			pac = service.modificar(paciente);
		} catch (Exception e) {
			new ResponseEntity<Paciente>(pac, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Paciente>(pac, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") int idPaciente) {
			service.eliminar(idPaciente);
	}

	@GetMapping("/{id}")
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
