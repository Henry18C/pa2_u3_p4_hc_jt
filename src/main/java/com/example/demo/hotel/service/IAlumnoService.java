package com.example.demo.hotel.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.demo.hotel.repository.modelo.Alumno;

public interface IAlumnoService {
	public CompletableFuture<Integer>  buscarEdadAsincrono(String cedula);
	
	public List<Alumno> budcarTodos();

}
