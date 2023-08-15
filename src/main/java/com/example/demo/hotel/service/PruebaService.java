package com.example.demo.hotel.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaService implements IPruebaService{

	@Override
	@Transactional(value = TxType.NEVER)//le decimos que esto es una transaccion, si no especifico por defecto es required

	public void pueba() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());//me dice si hay alguna transaccion activa
		System.out.println("Metodo de prueba");

	}

	@Override
	@Transactional(value = TxType.MANDATORY)//le decimos que esto es una transaccion, si no especifico por defecto es required

	public void pueba2() {
		// TODO Auto-generated method stub
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());//me dice si hay alguna transaccion activa
		System.out.println("Metodo de prueba2");

		
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)//le decimos que esto es una transaccion, si no especifico por defecto es required
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());//me dice si hay alguna transaccion activa
		System.out.println("Metodo de SUPPORTS");

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)//le decimos que esto es una transaccion, si no especifico por defecto es required

	public void pruebaNotSupported() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());//me dice si hay alguna transaccion activa
		System.out.println("Metodo de not supported");

	}

	@Override
	@Transactional(value = TxType.REQUIRED)//le decimos que esto es una transaccion, si no especifico por defecto es required

	public void required() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());//me dice si hay alguna transaccion activa
		System.out.println("Metodo de not supported");

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)//le decimos que esto es una transaccion, si no especifico por defecto es required

	public void requiresNew() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());//me dice si hay alguna transaccion activa
		System.out.println("Metodo de not supported");

	}

}
