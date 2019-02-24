package com.joseluis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseluis.model.Consulta;
import com.joseluis.service.IConsultaService;

@RestController
@RequestMapping(value= "/consulta")
public class ConsultaController {
	@Autowired
	private IConsultaService service;
	// PRUEBA
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Consulta>> listar(){
		List<Consulta> lista = new ArrayList<>();
		try {
			lista = service.listar();
		} catch (Exception e) {
			new ResponseEntity<List<Consulta>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
	}
		
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Consulta> registrar(@RequestBody Consulta consulta){
		Consulta con = new Consulta();
		try {
			con = service.registrar(consulta);
		} catch (Exception e) {
			new ResponseEntity<Consulta>(con, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Consulta>(con, HttpStatus.OK);
	}
	
	
}
