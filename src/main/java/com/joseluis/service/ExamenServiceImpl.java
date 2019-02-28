package com.joseluis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseluis.dao.IExamenDAO;
import com.joseluis.model.Examen;
@Service
public class ExamenServiceImpl implements IExamenService{

	@Autowired
	private IExamenDAO dao;
	@Override
	public Examen registrar(Examen examen) {
		return dao.save(examen);
	}

	@Override
	public void modificar(Examen examen) {
		dao.save(examen);
	}

	@Override
	public void eliminar(int idExamen) {
		dao.delete(idExamen);
	}

	@Override
	public Examen listarId(int idExamen) {
		return dao.findOne(idExamen);
	}

	@Override
	public List<Examen> listar() {
		return dao.findAll();
	}

}
