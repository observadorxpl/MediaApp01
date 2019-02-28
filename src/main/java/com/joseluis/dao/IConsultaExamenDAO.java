package com.joseluis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.joseluis.model.ConsultaExamen;
@Repository
public interface IConsultaExamenDAO extends JpaRepository<ConsultaExamen, Integer> {

	//NativeQuery para indicar que es un Query SQL y no JPQL
	@Modifying
	@Query(value = "INSERT INTO CONSULTA_EXAMEN(ID_CONSULTA, ID_EXAMEN) VALUES  (:idConsulta, :idExamen)", nativeQuery = true)
	//METODO MANUAL
	int registrar(@Param ("idConsulta")int idConsulta, @Param("idExamen") int idExamen);
}
