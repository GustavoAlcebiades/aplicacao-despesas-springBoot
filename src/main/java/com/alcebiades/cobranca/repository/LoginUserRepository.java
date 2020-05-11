package com.alcebiades.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alcebiades.cobranca.Models.LoginUsuario;

public interface LoginUserRepository extends JpaRepository<LoginUsuario, Long> {

}
