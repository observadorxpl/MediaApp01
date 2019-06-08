package com.joseluis.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluis.dao.IConsultaDAO;
import com.joseluis.dao.IConsultaExamenDAO;
import com.joseluis.model.Consulta;
import com.joseluis.util.ConsultaListaExamen;


@Service
public class ConsultaServiceImpl implements IConsultaService{
	@Autowired
	private IConsultaDAO dao;
	@Autowired
	private IConsultaExamenDAO dce;

	//@Transactional
	@Override
	public Consulta registrar(ConsultaListaExamen dto) {
		Consulta cons = new Consulta();
		try {
			dto.getConsulta().getDetalleConsulta().forEach(d -> d.setConsulta(dto.getConsulta()));
			cons = dao.save(dto.getConsulta());
			
			//System.out.println(dto.getConsulta().getIdConsulta());
			
			dto.getExamenes().forEach(e -> dce.registrar(dto.getConsulta().getIdConsulta(), e.getIdExamen()));
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		return cons;
		
		/*for(DetalleConsulta det: consulta.getDetalleConsulta()){
			det.setConsulta(consulta);
		}
		
		consulta.getDetalleConsulta().forEach(x -> {x.setConsulta(consulta);});
		return dao.save(consulta);
		*/
	}

	@Override
	public void modificar(Consulta consulta) {
		dao.save(consulta);
	}

	@Override
	public void eliminar(int idConsulta) {
		dao.delete(idConsulta);
	}

	@Override
	public Consulta listarId(int idConsulta) {
		return dao.findOne(idConsulta);
	}

	@Override
	public List<Consulta> listar() {
		return dao.findAll();
	}

}
