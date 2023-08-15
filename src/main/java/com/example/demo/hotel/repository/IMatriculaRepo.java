package com.example.demo.hotel.repository;

import com.example.demo.hotel.repository.modelo.Estudiante;
import com.example.demo.hotel.repository.modelo.Materia;
import com.example.demo.hotel.repository.modelo.Matricula;

public interface IMatriculaRepo {

	
	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public Matricula buscar(Integer id);
	
	
}
