package com.alcebiades.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alcebiades.cobranca.Models.Cadastro;

public interface Cadastros extends JpaRepository<Cadastro, Long> {

}