package com.example.demo.hotel.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table
@Entity
public class Propietario {

	
	
	@Column(name = "prop_id")
	@Id
	@SequenceGenerator(name = "seq_prop",sequenceName = "seq_prop",allocationSize = 1)
	@GeneratedValue(generator ="seq_prop",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "prop_nombre")
	private String nombre;
	
	@Column(name = "prop_apellido")
	private String apellido;
	
	@Column(name = "prop_cedula")
	private String cedula;

	@OneToMany(mappedBy = "propietario")
	private List<CuentaBancaria> cuentasBancarias;
}
