package com.joseluis.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluis.model.Consulta;
import com.joseluis.repository.IConsultaDAO;
import com.joseluis.repository.IConsultaExamenDAO;
import com.joseluis.util.ConsultaListaExamen;


@Service
public class ConsultaServiceImpl implements IConsultaService{
	@Autowired
	private IConsultaDAO dao;
	@Autowired
	private IConsultaExamenDAO dce;

	@Override
	public Consulta registrarTransaccional(ConsultaListaExamen dto) {
		try {
			dto.getConsulta().getDetalleConsulta().forEach(d -> d.setConsulta(dto.getConsulta()));
			dao.save(dto.getConsulta());
			
			
			
			dto.getExamenes().forEach(e -> {
				System.out.println("ID CONSULTA: "+ dto.getConsulta().getIdConsulta() +
						"IDEXAMEN: " + e.getIdExamen());
				dce.registrar(dto.getConsulta().getIdConsulta(), e.getIdExamen());
				});
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		return dto.getConsulta();
		
		/*for(DetalleConsulta det: consulta.getDetalleConsulta()){
			det.setConsulta(consulta);
		}
		
		consulta.getDetalleConsulta().forEach(x -> {x.setConsulta(consulta);});
		return dao.save(consulta);
		*/
	}

	@Override
	public Consulta registrar(Consulta cons) {	
		//Consulta sin examenes, solo con detalles(Diagnostico, tratamiento)
		cons.getDetalleConsulta().forEach(det -> det.setConsulta(cons));
		return dao.save(cons);
	}
	@Override
	public Consulta modificar(Consulta consulta) {
		return dao.save(consulta);
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
