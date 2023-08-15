package com.example.demo.hotel.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.hotel.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		entityManager.merge(estudiante);
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> query=this.entityManager.createQuery("select e from Estudiante e where e.cedula= :cedula", Estudiante.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
	}

}
