package com.joseluis.service;

import java.util.List;

import com.joseluis.model.Consulta;
import com.joseluis.util.ConsultaListaExamen;



public interface IConsultaService {
	Consulta registrar(ConsultaListaExamen consulta);
	void modificar(Consulta consulta);
	void eliminar(int idConsulta);
	Consulta listarId(int idConsulta);
	List<Consulta> listar();
}
