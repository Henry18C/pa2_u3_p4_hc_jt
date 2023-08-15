package com.example.demo.hotel.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.demo.hotel.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class TranferenciaRepositoryImpl implements ITrasferenciaRepository{

	
	@PersistenceContext 
	private EntityManager entityManager;
	@Override
	@Transactional(value =  TxType.MANDATORY)
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		entityManager.persist(transferencia);
		//throw new RuntimeException();

	}
	//Mandatory -> insertar, actualizar, eliminar
	//Not supported -> seleccionar, realizar trnasferencia
	@Override
	@Transactional(value =  TxType.NOT_SUPPORTED)
	public List<Transferencia> seleccionarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Transferencia> query= this.entityManager.createQuery("select t from Transferencia t", Transferencia.class);
		return query.getResultList();
	}

}
