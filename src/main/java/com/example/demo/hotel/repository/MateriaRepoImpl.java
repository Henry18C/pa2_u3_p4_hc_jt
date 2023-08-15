package com.example.demo.hotel.repository;

import java.lang.reflect.Type;

import org.springframework.stereotype.Repository;

import com.example.demo.hotel.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository

public class MateriaRepoImpl  implements IMateriaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		entityManager.persist(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		entityManager.merge(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query= this.entityManager.createQuery("select m from Materia m where m.codigo= :codigo", Materia.class) ;
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

}
