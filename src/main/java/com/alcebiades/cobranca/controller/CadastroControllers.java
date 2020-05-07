package com.alcebiades.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alcebiades.cobranca.Models.Cadastro;
import com.alcebiades.cobranca.Models.StatusCadastro;
import com.alcebiades.cobranca.repository.Cadastros;

@Controller
@RequestMapping("/despesas")
public class CadastroControllers {

	@Autowired
	Cadastros cadastros;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public ModelAndView salvar(Cadastro cadastro) {
		cadastros.save(cadastro);
		
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Valor Salvo com Sucesso!");
		
		return mv;
	}
	
	@RequestMapping()
	public ModelAndView pesquisar() {
		
		List<Cadastro> todosCadastros = cadastros.findAll();
		ModelAndView mv = new ModelAndView("PesquisaValor");
		mv.addObject("cadastros", todosCadastros);
		return mv;
	}
	
	
	@ModelAttribute("ListarStatus")
	public List<StatusCadastro> TodosStatusCadastro(){
		
		return Arrays.asList(StatusCadastro.values());
	}
	
}
