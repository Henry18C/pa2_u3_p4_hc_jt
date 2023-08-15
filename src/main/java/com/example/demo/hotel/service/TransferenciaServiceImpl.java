package com.example.demo.hotel.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.repository.ITrasferenciaRepository;
import com.example.demo.hotel.repository.modelo.CuentaBancaria;
import com.example.demo.hotel.repository.modelo.Transferencia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service 
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ICuentaBancariaService  bancariaService;
	
	@Autowired
	private ITrasferenciaRepository iTrasferenciaRepository;
	
	
	@Override
	public void realizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		iTrasferenciaRepository.insertar(transferencia);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void transferir(String numCuentaOrigen, String numCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		Transferencia transferencia= new Transferencia();
		
		CuentaBancaria cuentaOrigen= bancariaService.buscarPorNumero(numCuentaOrigen);
		CuentaBancaria cuentaDestino= bancariaService.buscarPorNumero(numCuentaDestino);
		
		System.out.println("Cuenta Origen: "+cuentaOrigen);
		System.out.println("Cuenta Destiono: "+cuentaDestino);
		BigDecimal montoInicialCuentaOrigen=cuentaOrigen.getSaldo();
		BigDecimal montoInicialCuentaDestino=cuentaDestino.getSaldo();
		BigDecimal montoFinalOrigen;
		BigDecimal montoFinalDestino;
		
		if(monto.compareTo(montoInicialCuentaOrigen)<1) {
			System.err.println("Se puede realizar la transferencia");
			
			montoFinalOrigen=montoInicialCuentaOrigen.subtract(monto);
			cuentaOrigen.setSaldo(montoFinalOrigen);
			bancariaService.actualizar(cuentaOrigen);
			
			
			montoFinalDestino=montoInicialCuentaDestino.add(monto);
			cuentaDestino.setSaldo(montoFinalDestino);
			bancariaService.actualizar(cuentaDestino);
			
			transferencia.setCtaDestino(cuentaDestino);
			transferencia.setCtaOrigen(cuentaOrigen);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			iTrasferenciaRepository.insertar(transferencia);
			System.err.println("Transferencia exitosa ;)");
			
			
		}else {
			System.err.println("No posee el dinero necesario para realizar la transaccion");
			
		
			throw new RuntimeException();
			
		}
		
		
		

		
		
	}

	@Override
	public List<Transferencia> buscarTodos() {
		// TODO Auto-generated method stub
		return iTrasferenciaRepository.seleccionarTodos();
	}

}
