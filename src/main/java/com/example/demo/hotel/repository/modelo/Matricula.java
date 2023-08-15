package com.example.demo.hotel.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "matricula", schema = "public")
@Entity
public class Matricula {

	@Id
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@Column(name = "mtla_id")
	private Integer id;
	
	@Column(name = "mtla_fecha_matricula")
	private LocalDateTime fechaDeMatricula;
	
	@Column(name = "mtla_numero_matricula")
	private Integer numeroDeMatricula;
	
	@Column(name = "mtla_valor_unitario")
	private BigDecimal valorUnitario;
	
	@ManyToOne()
	@JoinColumn(name = "mtla_id_alumno")
	private Estudiante estudiante;
	
	@ManyToOne()
	@JoinColumn(name = "mtla_id_materia")
	private Materia materia;

	
	//get and set
	

	//get and set
	public Integer getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaDeMatricula=" + fechaDeMatricula + ", numeroDeMatricula="
				+ numeroDeMatricula + ", valorUnitario=" + valorUnitario + "]";
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaDeMatricula() {
		return fechaDeMatricula;
	}

	public void setFechaDeMatricula(LocalDateTime fechaDeMatricula) {
		this.fechaDeMatricula = fechaDeMatricula;
	}





	public Integer getNumeroDeMatricula() {
		return numeroDeMatricula;
	}

	public void setNumeroDeMatricula(Integer numeroDeMatricula) {
		this.numeroDeMatricula = numeroDeMatricula;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	
	
}
