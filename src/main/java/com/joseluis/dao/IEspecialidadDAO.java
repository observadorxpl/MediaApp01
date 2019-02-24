package com.joseluis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseluis.model.Especialidad;
@Repository
public interface IEspecialidadDAO extends JpaRepository<Especialidad, Integer>{

}
