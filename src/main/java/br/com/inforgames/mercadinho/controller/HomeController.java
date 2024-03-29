package br.com.inforgames.mercadinho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("mensagem", "Mensagem da controller 'Home'");
		
		return model;
	}
}
