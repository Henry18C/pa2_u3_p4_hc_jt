package com.example.demo.hotel.service;

import com.example.demo.hotel.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	
	
	
	public void ingresar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscarPorCedula(String cedula);
	

}
