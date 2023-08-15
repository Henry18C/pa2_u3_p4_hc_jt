package com.example.demo.hotel.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.repository.IAlumnoRepo;
import com.example.demo.hotel.repository.modelo.Alumno;


@Service
public class AlumnoServiceImpl implements IAlumnoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private IAlumnoRepo alumnoRepo;
	 
	@Override
	@Async
	public CompletableFuture<Integer> buscarEdadAsincrono(String cedula) {
		// TODO Auto-generated method stub
		LOGGER.info("Hilo Service: "+ Thread.currentThread().getName());

        //SUMAR, RESTAR, MULTIPLICAR - LOGICA QUE SE DEMORA 1 SEGUNDO

        try {

            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }
        
        
        
//        String cedu= this.alumnoRepo.buscarCedula(cedula).getCedula();
       
        
//        System.err.println("Cedula: "+cedu);
        int edad=0;
        
        try {
             edad = this.alumnoRepo.buscarCedula(cedula).getEdad(); // Asumo que obtienes la edad desde el resultado de búsqueda

		} catch (Exception e) {
			 System.err.println("HOLA"+ cedula);
		}
        
        
        return CompletableFuture.completedFuture(edad);

	}

	@Override
	public List<Alumno> budcarTodos() {
		// TODO Auto-generated method stub
	
		return 	this.alumnoRepo.budcarTodos();
	}

}
