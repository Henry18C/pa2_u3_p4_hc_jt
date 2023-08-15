package com.example.demo.hotel.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.hotel.repository.modelo.Transferencia;

public interface ITransferenciaService {
	
	public void realizar(Transferencia transferencia);
	public void transferir(String cuentaOrigen, String Destino, BigDecimal monto);
	public List<Transferencia> buscarTodos();

}
