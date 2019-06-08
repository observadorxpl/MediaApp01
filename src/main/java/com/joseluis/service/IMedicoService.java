package com.joseluis.service;

import java.util.List;

import com.joseluis.model.Medico;

public interface IMedicoService {
	Medico registrar(Medico medico);
	void modificar(Medico medico);
	void eliminar(int idMedico);
	Medico listarId(int idPMedico);
	List<Medico> listar();

}
