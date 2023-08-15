package com.example.demo.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.repository.IMateriaRepo;
import com.example.demo.hotel.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService  {

	@Autowired
	private IMateriaRepo iMateriaRepo;
	
	
	@Override
	public void ingresar(Materia materia) {
		// TODO Auto-generated method stub
		iMateriaRepo.insertar(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		iMateriaRepo.actualizar(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return iMateriaRepo.buscarPorCodigo(codigo);
	}

}
