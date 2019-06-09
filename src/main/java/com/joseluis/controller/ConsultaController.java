package com.joseluis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseluis.model.Consulta;
import com.joseluis.service.IConsultaService;
import com.joseluis.util.ConsultaListaExamen;

@RestController
@RequestMapping(value= "/consultas")
public class ConsultaController {
	@Autowired
	private IConsultaService service;

	@GetMapping
	public ResponseEntity<List<Consulta>> listar(){
		List<Consulta> lista = new ArrayList<>();
		try {
			lista = service.listar();
		} catch (Exception e) {
			new ResponseEntity<List<Consulta>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
	}
		
	
	@PostMapping
	public ResponseEntity<Consulta> registrar(@RequestBody ConsultaListaExamen consultaListaExamenes){
		Consulta con = new Consulta();
		try {
			con = service.registrarTransaccional(consultaListaExamenes);
		} catch (Exception e) {
			new ResponseEntity<Consulta>(con, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Consulta>(con, HttpStatus.OK);
	}
	
	
}
