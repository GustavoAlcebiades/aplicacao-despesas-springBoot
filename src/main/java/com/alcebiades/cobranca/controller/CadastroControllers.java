package com.alcebiades.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		mv.addObject(new Cadastro());
		return mv;
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public String salvar(@Validated Cadastro cadastro, Errors erros, RedirectAttributes attributes) {
		if(erros.hasErrors()) {
			return "CadastroTitulo";
		}
		
		cadastros.save(cadastro);
		attributes.addFlashAttribute("mensagem", "Despesa salva com sucesso !");
		return "redirect:despesas/novo";
	}
	
	@RequestMapping()
	public ModelAndView pesquisar() {
		
		List<Cadastro> todosCadastros = cadastros.findAll();
		ModelAndView mv = new ModelAndView("PesquisaValor");
		mv.addObject("cadastros", todosCadastros);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Cadastro cadastro) {
		ModelAndView mv = new ModelAndView("CadastroTitulo"); 
		mv.addObject(cadastro);
		return mv;
	}
	
	@DeleteMapping(value="{codigo}")
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		
		cadastros.delete(codigo);
		
		attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
		return "redirect:/despesas";
	}
	
	
	@ModelAttribute("ListarStatus")
	public List<StatusCadastro> TodosStatusCadastro(){
		
		return Arrays.asList(StatusCadastro.values());
	}
	
}
