package com.example.demo.hotel.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table
@Entity
public class Transferencia {
	
	@Column(name = "trans_id")
	@Id
	@SequenceGenerator(name = "seq_trans",sequenceName = "seq_trans",allocationSize = 1)
	@GeneratedValue(generator ="seq_trans",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "trans_fecha")
	private LocalDateTime fecha ;
	
	@Column(name = "trans_monto")
	private BigDecimal monto;
	
	
   @ManyToOne
   @JoinColumn(name = "id_cta_origen")
   private CuentaBancaria ctaOrigen;
   
   @ManyToOne
   @JoinColumn(name = "id_cta_destino")
   private CuentaBancaria ctaDestino;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public LocalDateTime getFecha() {
	return fecha;
}

public void setFecha(LocalDateTime fecha) {
	this.fecha = fecha;
}

public BigDecimal getMonto() {
	return monto;
}

public void setMonto(BigDecimal monto) {
	this.monto = monto;
}

public CuentaBancaria getCtaOrigen() {
	return ctaOrigen;
}

public void setCtaOrigen(CuentaBancaria ctaOrigen) {
	this.ctaOrigen = ctaOrigen;
}

public CuentaBancaria getCtaDestino() {
	return ctaDestino;
}

public void setCtaDestino(CuentaBancaria ctaDestino) {
	this.ctaDestino = ctaDestino;
}

@Override
public String toString() {
	return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", ctaOrigen=" + ctaOrigen
			+ ", ctaDestino=" + ctaDestino + "]";
}


	
	



}
