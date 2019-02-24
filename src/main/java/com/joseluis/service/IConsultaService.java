package com.joseluis.service;

import java.util.List;

import com.joseluis.model.Consulta;



public interface IConsultaService {
	Consulta registrar(Consulta consulta);
	void modificar(Consulta consulta);
	void eliminar(int idConsulta);
	Consulta listarId(int idConsulta);
	List<Consulta> listar();
}
