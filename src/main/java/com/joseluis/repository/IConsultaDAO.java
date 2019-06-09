package com.joseluis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseluis.model.Consulta;
@Repository
public interface IConsultaDAO  extends JpaRepository<Consulta, Integer>{

}
