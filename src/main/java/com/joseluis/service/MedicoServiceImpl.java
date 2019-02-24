package com.joseluis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseluis.dao.IMedicoDAO;
import com.joseluis.model.Medico;
@Service
public class MedicoServiceImpl implements IMedicoService {
@Autowired
	private IMedicoDAO dao;
	@Override
	public Medico registrar(Medico medico) {
		return dao.save(medico);
	}

	@Override
	public void modificar(Medico medico) {
		dao.save(medico);
	}

	@Override
	public void eliminar(int idMedico) {
		dao.delete(idMedico);
	}
	

	@Override
	public Medico listarId(int idMedico) {
		return dao.findOne(idMedico);
	}

	@Override
	public List<Medico> listar() {
		return dao.findAll();
	}

}
