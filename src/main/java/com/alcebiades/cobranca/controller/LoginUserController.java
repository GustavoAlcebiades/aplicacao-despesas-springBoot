package com.alcebiades.cobranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alcebiades.cobranca.Models.LoginUsuario;
import com.alcebiades.cobranca.repository.LoginUserRepository;

@RestController
@RequestMapping("/user")
public class LoginUserController {

	@Autowired
	private LoginUserRepository loginUserRepository;

	@RequestMapping("/login")
	public ModelAndView home() {

		ModelAndView mv = new ModelAndView("LoginUser");
		mv.addObject(new LoginUsuario());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated LoginUsuario loginUsuario, Errors erros, RedirectAttributes attributes) {
		if (erros.hasErrors()) {
			return "PesquisaValor";
		}

		loginUserRepository.save(loginUsuario);
		attributes.addFlashAttribute("mensagem", "Cadastro Salvo com Sucesso !");
		return "redirect:user/login/pessoa";

	}

	@RequestMapping("/pessoa")
	public ModelAndView pesquisar(String nome) {

		List<LoginUsuario> todosLogin = loginUserRepository.findAll();
		ModelAndView mv = new ModelAndView("ListarUsuario");
		mv.addObject("loginUserRepository", todosLogin);
		return mv;
	}

}
