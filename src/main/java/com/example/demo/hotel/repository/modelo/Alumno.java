package com.example.demo.hotel.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="alumno")
@Entity
public class Alumno {
	
	@Id
	@Column(name="alum_id")
	@SequenceGenerator(allocationSize = 1, name = "seq_alum", sequenceName = "seq_alum")
	@GeneratedValue(generator = "seq_alum", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="alum_cedula")
	private String cedula;
	
	@Column(name="alum_nombre")
	private String nombre;
	
	@Column(name="alum_edad")
	private Integer edad;
	
	@Column(name="alum_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	

}
