package com.joseluis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseluis.dao.IPacienteDAO;
import com.joseluis.model.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService{
@Autowired
	private IPacienteDAO dao;
	@Override
	public Paciente registrar(Paciente paciente) {
		return dao.save(paciente);
	}

	@Override
	public void modificar(Paciente paciente) {
		dao.save(paciente);
	}

	@Override
	public void eliminar(int idPaciente) {
		dao.delete(idPaciente);
	}


	@Override
	public Paciente listarId(int idPaciente) {
		return dao.findOne(idPaciente);
	}

	@Override
	public List<Paciente> listar() {
		return dao.findAll();
	}
}
