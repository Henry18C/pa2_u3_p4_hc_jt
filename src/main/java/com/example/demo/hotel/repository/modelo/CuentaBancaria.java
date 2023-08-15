package com.example.demo.hotel.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class CuentaBancaria {
	
	@Column(name = "cuen_id")
	@Id
	@SequenceGenerator(name = "seq_cuenta",sequenceName = "seq_cuenta",allocationSize = 1)
	@GeneratedValue(generator ="seq_cuenta",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "cuen_numero")
	private String numero;
	
	@Column(name = "cuen_asaldo")
	private BigDecimal saldo;
	
	@Column(name = "cuen_tipo")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "id_propietario")
	private Propietario propietario;
	
	
	 @OneToMany(mappedBy = "ctaOrigen")
	 private List<Transferencia> transferenciasOrigen;

	 @OneToMany(mappedBy = "ctaDestino")
	 private List<Transferencia> transferenciasDestino;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public List<Transferencia> getTransferenciasOrigen() {
		return transferenciasOrigen;
	}

	public void setTransferenciasOrigen(List<Transferencia> transferenciasOrigen) {
		this.transferenciasOrigen = transferenciasOrigen;
	}

	public List<Transferencia> getTransferenciasDestino() {
		return transferenciasDestino;
	}

	public void setTransferenciasDestino(List<Transferencia> transferenciasDestino) {
		this.transferenciasDestino = transferenciasDestino;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo
				+ ", propietario=" + propietario + "]";
	}
	
	
	
	
	

}
