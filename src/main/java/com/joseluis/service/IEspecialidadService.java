package com.joseluis.service;

import java.util.List;

import com.joseluis.model.Especialidad;

public interface IEspecialidadService {
	Especialidad registrar(Especialidad especialidad);
	void modificar(Especialidad especialidad);
	void eliminar(int idEspecialidad);
	Especialidad listarId(int idPEspecialidad);
	List<Especialidad> listar();
}
