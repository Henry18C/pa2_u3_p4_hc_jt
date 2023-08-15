package com.example.demo.hotel.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.hotel.repository.modelo.CuentaBancaria;
import com.example.demo.hotel.service.IPruebaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{
	@Autowired
	private IPruebaService iPruebaService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional()//le decimos que esto es una transaccion, si no especifico por defecto es required
	public void insertar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		entityManager.persist(cuentaBancaria);
	}

	
	@Override
	@Transactional(value =  TxType.REQUIRED)
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		entityManager.merge(bancaria);
	}

	@Override
	public CuentaBancaria seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public CuentaBancaria seleccionarPorNumero(String numCuenta) {
		// TODO Auto-generated method stub
		
		TypedQuery<CuentaBancaria> query= this.entityManager.createQuery("Select c from CuentaBancaria c where c.numero= :numCuenta",CuentaBancaria.class);
		query.setParameter("numCuenta", numCuenta);
		
		return query.getSingleResult();
	}

}
