package com.example.demo.hotel.repository;

import com.example.demo.hotel.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	
	public void insertar(CuentaBancaria cuentaBancaria);
	
	public void actualizar(CuentaBancaria bancaria);
	
	public CuentaBancaria seleccionar(Integer id);
	public CuentaBancaria seleccionarPorNumero(String numCuenta);
	

}
