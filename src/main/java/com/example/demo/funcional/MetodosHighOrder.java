package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {

	
	 final Logger LOG= LoggerFactory.getLogger(MetodosHighOrder.class);

public void metodo(IPersonaSupplier<String> funcion) {
	
	
	LOG.info("Hight Order supplier"+funcion.getId());
	
	

	
}


public static void metodoConsumer(IPersonaConsumer<String> funcion, String cadena) {
	
	 funcion.accept(cadena);
	
	
	
}






}
