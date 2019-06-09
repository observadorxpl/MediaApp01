package com.joseluis.service;

import com.joseluis.model.Consulta;
import com.joseluis.util.ConsultaListaExamen;

public interface IConsultaService extends ICRUD<Consulta> {
	
	Consulta registrarTransaccional(ConsultaListaExamen consultaDTO);
}
