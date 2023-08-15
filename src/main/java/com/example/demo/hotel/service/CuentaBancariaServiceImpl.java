package com.example.demo.hotel.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.hotel.repository.ICuentaBancariaRepo;
import com.example.demo.hotel.repository.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService  {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	
	
	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepository;
	
	
	@Autowired
	private IPruebaService iPruebaService;
	
	@Override
	//@Transactional(value = TxType.REQUIRED)//le decimos que esto es una transaccion, si no especifico por defecto es required

	public void insertar(CuentaBancaria cuentaBancaria) {
		System.out.println("Service: "+TransactionSynchronizationManager.isActualTransactionActive());//me dice si hay alguna transaccion activa
		cuentaBancariaRepository.insertar(cuentaBancaria);
		//this.iPruebaService.pueba();
		//this.iPruebaService.pueba2();
		//iPruebaService.pruebaNotSuppots();
		//iPruebaService.required();
		
		LOGGER.info("Hilo Service: "+ Thread.currentThread().getName());
		//SUMAR, RESTAR, MULTIPLICAR - LOGICA QUE SE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		this.iPruebaService.requiresNew();

	}

	@Override
	
	public void actualizar(CuentaBancaria bancaria) {
		cuentaBancariaRepository.actualizar(bancaria);
	}

	@Override
	public CuentaBancaria buscar(Integer id) {
		return cuentaBancariaRepository.seleccionar(id);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numCuenta) {
		// TODO Auto-generated method stub
		return cuentaBancariaRepository.seleccionarPorNumero(numCuenta);
	}

	@Override

	public void prueba() {
		// TODO Auto-generated method stub
		System.err.println("hola");
	}


	
	
	
	@Override
	public String agregarDos(CuentaBancaria cuentaBancaria) {
		LOGGER.info("Hilo Service: "+ Thread.currentThread().getName());
		//SUMAR, RESTAR, MULTIPLICAR - LOGICA QUE SE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//this.cuentaBancariaRepository.insertar(cuentaBancaria);

		this.cuentaBancariaRepository.insertar(cuentaBancaria);
		return cuentaBancaria.getNumero();
	}

	@Override

    @Async

    public void agregarAsincrono(CuentaBancaria cuentaBancaria) {

        LOGGER.info("Hilo Service: "+ Thread.currentThread().getName());

        //SUMAR, RESTAR, MULTIPLICAR - LOGICA QUE SE DEMORA 1 SEGUNDO

        try {

            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        

        this.cuentaBancariaRepository.insertar(cuentaBancaria);

        

 
    }

	@Override
	@Async
	public CompletableFuture<String>  agregarAsincrono2(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		LOGGER.info("Hilo Service: "+ Thread.currentThread().getName());

        //SUMAR, RESTAR, MULTIPLICAR - LOGICA QUE SE DEMORA 1 SEGUNDO

        try {

            TimeUnit.SECONDS.sleep(10);

        } catch (InterruptedException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        

        this.cuentaBancariaRepository.insertar(cuentaBancaria);
		return CompletableFuture.completedFuture(cuentaBancaria.getNumero());

        

	}
	
	
}
