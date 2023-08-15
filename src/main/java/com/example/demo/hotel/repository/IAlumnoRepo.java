package com.example.demo.hotel.repository;

import java.util.List;

import com.example.demo.hotel.repository.modelo.Alumno;

public interface IAlumnoRepo {
	
	public Alumno buscarCedula(String cedula);
	
	public List<Alumno> budcarTodos  ();

}
