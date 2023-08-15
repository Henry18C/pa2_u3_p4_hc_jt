package com.example.demo.hotel.repository;

import com.example.demo.hotel.repository.modelo.Estudiante;

public interface IEstudianteRepo {
	
	
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscarPorCedula(String cedula);
	


}
