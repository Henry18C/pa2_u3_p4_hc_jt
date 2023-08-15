package com.example.demo.hotel.repository;

import com.example.demo.hotel.repository.modelo.Materia;

public interface IMateriaRepo {
	
	public void insertar(Materia materia);
	
	
	public void actualizar(Materia materia);
	
	public Materia buscarPorCodigo(String codigo);

}
