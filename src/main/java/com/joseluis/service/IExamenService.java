package com.joseluis.service;

import java.util.List;

import com.joseluis.model.Examen;

public interface IExamenService {
	Examen registrar(Examen examen);
	void modificar(Examen examen);
	void eliminar(int idExamen);
	Examen listarId(int idExamen);
	List<Examen> listar();
}
