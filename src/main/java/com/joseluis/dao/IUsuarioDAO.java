package com.joseluis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joseluis.model.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
	/*@Transactional
	@Modifying
	@Query(value = "SELECT * FROM USUARIO WHERE USUARIO = :usuario_text AND PASSWORD = :password_text)", nativeQuery = true)
	int login(@Param("usuario_text")String usuario, @Param("password_text") String password);*/
}
