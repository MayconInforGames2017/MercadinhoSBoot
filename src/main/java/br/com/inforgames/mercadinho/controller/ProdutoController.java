package br.com.inforgames.mercadinho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.inforgames.mercadinho.repository.FornecedorRepository;
import br.com.inforgames.mercadinho.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private FornecedorRepository fornecedorRepository;

}
