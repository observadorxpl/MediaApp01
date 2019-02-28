package com.joseluis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseluis.model.Examen;
@Repository
public interface IExamenDAO  extends JpaRepository<Examen, Integer>{

}
