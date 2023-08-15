package com.example.demo.hotel.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.repository.IMatriculaRepo;
import com.example.demo.hotel.repository.modelo.Estudiante;
import com.example.demo.hotel.repository.modelo.Materia;
import com.example.demo.hotel.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepo iMatriculaRepo;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IMateriaService iMateriaService;
	
	
	@Override
	public void ingresar(Matricula matricula) {
		// TODO Auto-generated method stub
		iMatriculaRepo.insertar(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		iMatriculaRepo.actualizar(matricula);
	}

	@Override
	public Matricula buscar(Integer id) {
		// TODO Auto-generated method stub
		return iMatriculaRepo.buscar(id);
	}

	@Override
	public void matricular(String cedula, List<String> codigoLST) {
		// TODO Auto-generated method stub
		
		
		Estudiante  estudiante= estudianteService.buscarPorCedula(cedula);
		
		
	
		
		for (String codigo : codigoLST) {
			Matricula matricula= new Matricula();
			Materia materia= this.iMateriaService.buscarPorCodigo(codigo);
			System.err.println(materia);
			matricula.setFechaDeMatricula(LocalDateTime.now());
			matricula.setMateria(materia);
			matricula.setValorUnitario(new BigDecimal(10));
			matricula.setEstudiante(estudiante);
			matricula.setNumeroDeMatricula(1);
		
			
			
			this.ingresar(matricula);
			System.out.println("MATRICULA EXITOSA");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
