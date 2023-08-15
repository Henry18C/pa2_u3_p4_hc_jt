package com.example.demo.hotel.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.hotel.repository.modelo.Materia;
import com.example.demo.hotel.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepoImpl implements IMatriculaRepo {

	@PersistenceContext 
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		entityManager.persist(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		entityManager.merge(matricula);
	}

	@Override
	public Matricula buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Matricula.class, id);
	}

}
