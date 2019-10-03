package br.com.inforgames.mercadinho.servico.dao;

import br.com.inforgames.mercadinho.model.Produto;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeNomeException;

public interface ProdutoService {
	
	Produto salvar(Produto produto) throws UnicidadeNomeException;

}
