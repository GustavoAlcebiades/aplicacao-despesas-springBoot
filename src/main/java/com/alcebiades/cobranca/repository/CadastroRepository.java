package com.alcebiades.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alcebiades.cobranca.Models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

	public List<Cadastro> findByDescricaoContaining(String descricao);

	
}
