package com.alcebiades.cobranca.Models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cadastro {

	private String descricao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date DataVencimento;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private StatusCadastro status;
	

public Cadastro() {
}


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}


public long getCodigo() {
	return codigo;
}


public void setCodigo(long codigo) {
	this.codigo = codigo;
}


public Date getDataVencimento() {
	return DataVencimento;
}


public void setDataVencimento(Date dataVencimento) {
	DataVencimento = dataVencimento;
}


public BigDecimal getValor() {
	return valor;
}


public void setValor(BigDecimal valor) {
	this.valor = valor;
}


public StatusCadastro getStatus() {
	return status;
}


public void setStatus(StatusCadastro status) {
	this.status = status;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (codigo ^ (codigo >>> 32));
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cadastro other = (Cadastro) obj;
	if (codigo != other.codigo)
		return false;
	return true;
}




}

