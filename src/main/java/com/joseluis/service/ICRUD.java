package com.joseluis.service;

import java.util.List;


public interface ICRUD<T> {
	T registrar(T t);
	T modificar(T t);
	void eliminar(int t);
	T listarId(int t);
	List<T> listar();
}
