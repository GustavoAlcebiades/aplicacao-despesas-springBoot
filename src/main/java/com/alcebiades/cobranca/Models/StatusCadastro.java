package com.alcebiades.cobranca.Models;

public enum StatusCadastro {
	
	PENDENTE("Pendente"),
	RECEBIDO("Recebido"),
	PAGO("Pago");
	
	private String descricao;
	
	StatusCadastro(String descricao){
		
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		
		return descricao;
	}
}
