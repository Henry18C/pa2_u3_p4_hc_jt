package com.example.demo.hotel.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.hotel.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	
public void insertar(CuentaBancaria cuentaBancaria);
	
	public void actualizar(CuentaBancaria bancaria);
	
	public CuentaBancaria buscar(Integer id);
	public CuentaBancaria buscarPorNumero(String numCuenta);
	
	
	public void prueba();
	public String agregarDos(CuentaBancaria cuentaBancaria);
	public void agregarAsincrono(CuentaBancaria cuentaBancaria);

	public CompletableFuture<String>  agregarAsincrono2(CuentaBancaria cuentaBancaria);


}
