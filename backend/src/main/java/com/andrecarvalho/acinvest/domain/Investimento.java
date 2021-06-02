package com.andrecarvalho.acinvest.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Investimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String codigoAtivo;
	
	private Double valor;
	
	private Integer cota;
	
	private LocalDate compra;
	
	@ManyToOne
	@JoinColumn(name="fk_codigo_categoria")
	private Categoria categoria;
	
	public Investimento() {
	}

	public Investimento(Integer id, String codigoAtivo, Double valor, Integer cota, LocalDate compra, Categoria categoria) {
		this.id = id;
		this.codigoAtivo = codigoAtivo;
		this.valor = valor;
		this.cota = cota;
		this.compra = compra;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoAtivo() {
		return codigoAtivo;
	}

	public void setCodigoAtivo(String codigoAtivo) {
		this.codigoAtivo = codigoAtivo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getCota() {
		return cota;
	}

	public void setCota(Integer cota) {
		this.cota = cota;
	}

	public LocalDate getCompra() {
		return compra;
	}

	public void setCompra(LocalDate compra) {
		this.compra = compra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public Categoria getTipo() {
		return categoria;
	}

	public void setTipo(Categoria tipo) {
		this.categoria = tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investimento other = (Investimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
