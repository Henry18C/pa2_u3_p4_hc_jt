package com.example.demo.hotel.service;

import com.example.demo.hotel.repository.modelo.Materia;

public interface IMateriaService {
	
	public void ingresar(Materia materia);
	
	
	public void actualizar(Materia materia);
	
	public Materia buscarPorCodigo(String codigo);

}
