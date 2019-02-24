package com.joseluis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseluis.dao.IEspecialidadDAO;
import com.joseluis.model.Especialidad;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService{
	@Autowired
		private IEspecialidadDAO dao;
	
	@Override
	public Especialidad registrar(Especialidad especialidad) {
		return dao.save(especialidad);
	}
	
	@Override
	public void modificar(Especialidad especialidad) {
		dao.save(especialidad);
	}
	
	@Override
	public void eliminar(int idEspecialidad) {
		dao.delete(idEspecialidad);
	}
	
	@Override
	public Especialidad listarId(int idEspecialidad) {
		return dao.findOne(idEspecialidad);
	}
	
	@Override
	public List<Especialidad> listar() {
		return dao.findAll();
	}

}
