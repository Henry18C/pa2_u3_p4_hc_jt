package com.example.demo.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {


	private static final Logger LOG= LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		IPersona persona= new PersonaImpl();
		persona.caminar();
		
		//1.SUPPLIER
		//clases
		
			IPersonaSupplier< String> supplier= new PersonaSupplierImpl();
			LOG.info("SUPPLIER CLASE:"+ supplier.getId());
		//lambdas
			IPersonaSupplier<String> supplier2= ()-> "1234";
			LOG.info("SUPPLIER LAMBDA:"+ supplier2.getId());
		
			IPersonaSupplier<String> supplier3= ()-> {
				
				String cedula="1234";
				cedula=cedula.concat("ZZZ");
				return cedula;
			};
			LOG.info("SUPPLIER LAMBDA2:"+ supplier3.getId());
			
			//metodos referenciados
			
			   MetodosReferenciados metodos= new MetodosReferenciados();
		
			   IPersonaSupplier<Integer> supplier4= MetodosReferenciados::getId;  //metodos referenacidos
				LOG.info("SUPPLIER Metodo referenciado:"+ supplier4.getId());

			
			//2: Consumer

	        //Clases

	        IPersonaConsumer<String> consumer1 = new PersonaCosummerImpl();

	        LOG.info("Consumer Clase: ");

	        consumer1.accept("Juan Toscano");
	        
	        
	        
	        IPersonaConsumer<String> consumer2 =  cadena-> LOG.info(cadena);

	        LOG.info("Consumer Lambda: ");

	        consumer2.accept("Juan Toscano - Henry Coyago");
	        
	        
	        //metodo referenciado
	        IPersonaConsumer<String> consumer3= MetodosReferenciados::aceptar;
	        LOG.info("Metodo Autoreferenciado: ");
	        consumer3.accept("NNNNN");
			
	      //3. Predicate

	        //Lambdas

	        IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8)==0;

	        LOG.info("Predicate Lambda1: " + predicate1.evaluar(4));

	        

	        IPersonaPredicate<Integer> predicate2 = valor -> {

	            Integer valor2 = 10;

	            valor = valor + valor2;

	            if(valor.compareTo(100)>0) {

	                return true;

	            }

	            else {

	                return false;

	            }

	            };

	       
			
	        
	            LOG.info("Predicate Lambda2: " + predicate2.evaluar(4));
	  
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        IPersonaPredicate<String> predicate3 = letra -> "Henry".contains(letra);
	        
	        
	        LOG.info("Predicate Lambda3: " + predicate3.evaluar("H"));
	        

	        IPersonaBiPredicate<String, String> predicate4 = (letra, cadena ) ->cadena.contains(letra);
	        
	        
	        LOG.info("Predicate Lambda4 Bipredicate: " + predicate4.evaluar("g", "henry"));
	        
	        
	        //predicate metodo autoreferenciado
	        
	        IPersonaPredicate<String > predicate5= metodos::evaluar;
	        
	        LOG.info("Predicate5 Autoeferenciado: " + predicate5.evaluar("henry"));

	        
	        
	        
	        //Function
	        
	        IPersonaFunction<String, Integer> function1= numero -> numero.toString();
	        LOG.info("Funtion Lambda1: " + function1.apply(8));


	        
	        
	        IPersonaFunction<String, Integer> function2= numero -> {
	        	
	        	String valorFinal= numero.toString().concat("valor");
	        	
	        	
	        	return valorFinal;
	        }
	        ;
	        LOG.info("Funtion Lambda2 : " + function2.apply(10));

	        
	       
	        
	        
	        //Unary
	        IPersonaUnaryOperator<Integer> unary= numero-> numero+(numero*2);
	        
	        
	        LOG.info("unary Lambda1 : " + unary.apply(10));

	        
	        IPersonaUnaryOperatorFunction<Integer>  unary2= numero-> numero+(numero*2);
	        LOG.info("unary Function Lambda1  : " + unary2.apply(10));
	        //Unary autoreferenciado
	        
	        IPersonaFunction<String, Integer > funcion3= metodos::retorna;
	        LOG.info("FUNCTION AUTOREFERENCIADO: " +funcion3.apply(8));
	        
	        IPersonaUnaryOperator<Integer> unary3= metodos::apply1;
	        LOG.info("UNARY AUTOREFERENCIADO : " + unary3.apply(5));

	        
	        /*METODOS HIGHT ORDEr*/

	        //SUPPIER
	        MetodosHighOrder highOrder= new MetodosHighOrder();
	        
	        //1 clase
			IPersonaSupplier< String> supplierHO= new PersonaSupplierImpl();
	        highOrder.metodo(supplierHO);
	        //2 lambda
	        
	        highOrder.metodo(()-> "1234 HO");
	        //3 referenciados
	        
	        highOrder.metodo(MetodosReferenciados::getIdHO);
	        
	        //CONSUMER
	        
	        //1 clase
	        highOrder.metodoConsumer(new PersonaCosummerImpl(), "consumer clase");

	        //2 lamdas
	        highOrder.metodoConsumer(cadena->LOG.info(cadena), "consumer lamdas");

	        //referenciado
	        highOrder.metodoConsumer(MetodosReferenciados::aceptar,"Consumer referenciado ");

	        
	       
	        
	        //interfaces funcionales JAVA
	        ///1. Supplier
	          Stream <String> lista=  Stream.generate(()-> "1236465465").limit(10);
	          lista.forEach(cadena-> LOG.info(cadena));
	        //2. Consumer
	          
	          List<Integer> listaNumeros= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
	          
	          listaNumeros.forEach(cadena ->{
	        	  LOG.info(""+cadena);
	          });
	          
	          //3 predicate
	          
	          Stream<Integer> listaFinal =listaNumeros.stream().filter(numero ->numero>=5);
	          
	          listaFinal.forEach(numero-> LOG.info("Valor mayor: " +numero));
	        
	          
	          //4. function
	          Stream<String> listaCambiada=  listaNumeros.stream().map((numero-> 
	          {
	        	  Integer num=10;
	        	  num=numero+num;
	        	  return "N:"+numero;
	          }
	        		  ));
	          
	          listaCambiada.forEach(cadena-> LOG.info(cadena));
	          
	          //5. Unary operator
	          
	          Stream<Integer> listaCambiada2=  listaNumeros.stream().map((numero-> 
	          {
	        	  Integer num=10;
	        	  num=numero+num;
	        	  return num;
	          }
	        		  ));
	          
	          listaCambiada2.forEach(cadena-> LOG.info(cadena.toString()));
	          
	          
	          
	          
	          
	          
	          
	          
	          
	          
	        
	}}
	   

