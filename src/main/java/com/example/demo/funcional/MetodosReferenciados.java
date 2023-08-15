package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {

	
	private static final Logger LOG= LoggerFactory.getLogger(Main.class);

	public  static Integer getId() {
		
		return 8;
	}
	
	
	
	public static void aceptar(String arg) {
		
		String cadena="henry" ;
		
		LOG.info(cadena+ " "+ arg);
	}
	
	
	
	
	public boolean evaluar (String arg) {
		String letra="h" ;
		return arg.contains(letra);
		
	}
	
	public String retorna(Integer arg) {
		String valor=arg.toString();
		return " El numero ingresado es:" +valor;
	}
	
	public Integer apply1(Integer arg) {
		
		return arg=arg*arg; 
	}
	
	
	public static String getIdHO() {
		
		String cadena= "Henry"; 
		
	
		return "SUPPIER REferenciado"+ cadena;
	}
	
	
	
	
	
}
