package com.example.demo.hotel.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Provincia {
	
	
	@Id
	@SequenceGenerator(name = "seq_provincia", sequenceName = "seq_provincia", allocationSize = 1)
	@GeneratedValue(generator = "seq_provincia", strategy = GenerationType.SEQUENCE)
	@Column(name = "prov_id")
	private Integer id;
	
	@Column(name = "prov_inombre")
	private String nombre;
	
	
	@Column(name = "prov_cantidad_habitantes")
	private Double cantidadHabitantes;
	
	@Column(name = "prov_salario_promedio")
	private BigDecimal salarioPromedio; 
	
	
	@OneToMany(mappedBy = "provincia")
	private List<Estudiante> estudiantes;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getCantidadHabitantes() {
		return cantidadHabitantes;
	}


	public void setCantidadHabitantes(Double cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}


	public BigDecimal getSalarioPromedio() {
		return salarioPromedio;
	}


	public void setSalarioPromedio(BigDecimal salarioPromedio) {
		this.salarioPromedio = salarioPromedio;
	}


	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}


	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	
	
	
	
}
