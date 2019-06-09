package com.joseluis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseluis.model.Medico;

@Repository
public interface IMedicoDAO extends JpaRepository<Medico, Integer> {

}
