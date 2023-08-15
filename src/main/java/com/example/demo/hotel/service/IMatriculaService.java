package com.example.demo.hotel.service;

import java.util.List;

import com.example.demo.hotel.repository.modelo.Matricula;

public interface IMatriculaService {
	
	
	
	public void ingresar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public Matricula buscar(Integer id);
	
	
	public void matricular(String cedula, List<String> codigo);
	

}
