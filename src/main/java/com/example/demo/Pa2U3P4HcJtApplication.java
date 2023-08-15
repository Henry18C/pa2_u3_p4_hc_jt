package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.hotel.repository.modelo.Alumno;
import com.example.demo.hotel.repository.modelo.CuentaBancaria;
import com.example.demo.hotel.service.IAlumnoService;
import com.example.demo.hotel.service.ICuentaBancariaService;
import com.example.demo.hotel.service.IEstudianteService;
import com.example.demo.hotel.service.IMateriaService;
import com.example.demo.hotel.service.IMatriculaService;
import com.example.demo.hotel.service.ITransferenciaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4HcJtApplication implements CommandLineRunner {

@Autowired
private IEstudianteService estudianteService;
@Autowired
private IMateriaService iMateriaService;
@Autowired
private IMatriculaService iMatriculaService;


@Autowired
private ICuentaBancariaService cuentaBancariaService;
	
@Autowired
private ITransferenciaService iTransferenciaService;


@Autowired
private IAlumnoService alumnoService;

private static final Logger LOGGER = LoggerFactory.getLogger(Pa2U3P4HcJtApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4HcJtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
System.err.println("INICIO");
		 
		  
		 
		 List<Alumno> alumnos= this.alumnoService.budcarTodos();
		 List<String> cedulas = new ArrayList<>();

		for (Alumno alumno : alumnos) {
			cedulas.add(alumno.getCedula());
			
		}
	        for (String string : cedulas) {
	        	//veo las cedulas guardadas
				System.err.println(string);
			}
	   

	        List<CompletableFuture<Integer>> consultaFutures = new ArrayList<>();
long tiempoInicial = System.currentTimeMillis();
	        for (String cedula : cedulas) {
	        	
	        	
	            CompletableFuture<Integer> consultaFuture = alumnoService.buscarEdadAsincrono(cedula);
	         
	            consultaFutures.add(consultaFuture);
	        }

	        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(
	                consultaFutures.toArray(new CompletableFuture[0])
	        );

	        allOfFuture.thenRun(() -> {
	            int totalEdad = 0;
	            for (CompletableFuture<Integer> future : consultaFutures) {
	                try {
	                    totalEdad += future.get(); // Obtengo el resultado del CompletableFuture
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    System.err.println("ERROR");
	                }
	            }

	            double promedioEdad = (double) totalEdad / cedulas.size();
	            LOGGER.info("Promedio de edades: " + promedioEdad);
	        });

	        // Espero a que todas las consultas y el cálculo del promedio terminen
	        allOfFuture.join();
		  
		
		
		
		
	        long tiempoFinal = System.currentTimeMillis();

	        long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;

	        LOGGER.info("Tiempo Transcurrido: "+(tiempoFinal - tiempoInicial));

	        LOGGER.info("Tiempo Transcurrido: "+tiempoTranscurrido);

	        LOGGER.info("Se termino de procesar todo");
		
		
	        System.err.println("FIN");		 


		
		
		


		
		
		
		
		
		
		
		
		
		
		
		
	
	/*	
		 //Asincrono futuro sin respuesta

        List<CuentaBancaria> listaCuentas = new ArrayList<>();

        long tiempoInicial = System.currentTimeMillis();

        for (int i =0; i<=10; i++){

            CuentaBancaria cuentaBancaria = new CuentaBancaria();

            cuentaBancaria.setNumero(String.valueOf(i));

            cuentaBancaria.setTipo("Corriente");

            cuentaBancaria.setSaldo(new BigDecimal(2000));

            listaCuentas.add(cuentaBancaria);

           this.cuentaBancariaService.agregarAsincrono(cuentaBancaria);

        }

       

        //List<String> listaFinal = listaCuentas.parallelStream()

                //.map(cuenta ->this.cuentaBancariaService.agregarDos(cuenta))

                //.collect(Collectors.toList());

        

        //Cuando se mantiene una lista en el registro con funcionalidad forEach

        //Stream<String> listaFinal = listaCuentas.parallelStream().map(cuenta ->this.cuentaBancariaService.agregarDos(cuenta));

        //LOGGER.info("Se guardaron las siguientes cuentas: ");

        //listaFinal.forEach(cadena ->LOGGER.info(cadena));

       

        //Fin

        long tiempoFinal = System.currentTimeMillis();

        long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;

        LOGGER.info("Tiempo Transcurrido: "+(tiempoFinal - tiempoInicial));

        LOGGER.info("Tiempo Transcurrido: "+tiempoTranscurrido);

        LOGGER.info("Se termino de procesar todo");
  */      
        
        
        
        //Asincrono futuro con respuesta
        
        
        
        
        
        
        
        
        
        
        
        
        
        
		
		
		
			}
		
	}


