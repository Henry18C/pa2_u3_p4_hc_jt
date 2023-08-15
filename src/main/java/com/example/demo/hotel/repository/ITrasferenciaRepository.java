package com.example.demo.hotel.repository;

import java.util.List;

import com.example.demo.hotel.repository.modelo.Transferencia;

public interface ITrasferenciaRepository {
	
	
	
	public void insertar(Transferencia transferencia);
	
	public List<Transferencia> seleccionarTodos();

}
