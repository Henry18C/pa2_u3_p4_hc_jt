package com.example.demo.hotel.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.hotel.repository.modelo.Alumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlumnoRepoImpl implements IAlumnoRepo{

	
		@PersistenceContext
		private EntityManager entityManager;
	@Override
	public Alumno buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		
		TypedQuery<Alumno> query= this.entityManager.createQuery("Select a from Alumno a where a.cedula= :cedula",Alumno.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
	}
	@Override
	public List<Alumno> budcarTodos() {
		TypedQuery<Alumno> query= this.entityManager.createQuery("Select a from Alumno a",Alumno.class);
		return query.getResultList();
	}

}
