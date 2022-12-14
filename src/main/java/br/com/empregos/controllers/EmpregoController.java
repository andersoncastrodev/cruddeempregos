package br.com.empregos.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.empregos.model.Emprego;
import br.com.empregos.repository.EmpregoRepository;


@Controller
public class EmpregoController {

	@Autowired
	EmpregoRepository empregoRepository;
	
	
	@RequestMapping("/")
	public String listaEmpregos(Model model) {
		
		model.addAttribute("empregos", empregoRepository.findAll());
		
		return "list";
	}
	
	
	@GetMapping("/add")
	public String empregoForm(Model model) {
		
		model.addAttribute("emprego", new Emprego() );
		return "empregoForm";
	}
	
	@PostMapping("/salvando")
	public String processForm(@Valid Emprego emprego, BindingResult result) {
		 
		if(result.hasErrors()) { //Se Tiver erros Entra aqui.
			return "empregoForm";
		}
		empregoRepository.save(emprego);
		return "redirect:/";
	}
	
    @GetMapping("/vieweditar/{id}")
    public String viewFormEditar(@PathVariable("id") Long id, Model model) {
    	
        Emprego emprego = empregoRepository.findAllById(id);
		
		model.addAttribute("empregos", emprego);
		
       return "empregoEditar";	
    }
    
	@PostMapping("editar/{id}")
	public String editar(@Valid Emprego emprego, BindingResult result, @PathVariable Long id) {
	   
		if(result.hasErrors()) { //Se Tiver erros Entra aqui.
			return "empregoEditar";
		}
		empregoRepository.save(emprego);
		
		return "redirect:/";		
	}
	
	@GetMapping("/deletar{id}")
	public String deletar(@PathVariable Long id, Model model ) {
		
		Emprego emprego = empregoRepository.findAllById(id);
		
		empregoRepository.delete(emprego);
		
		return "redirect:/";
	}
	
}
