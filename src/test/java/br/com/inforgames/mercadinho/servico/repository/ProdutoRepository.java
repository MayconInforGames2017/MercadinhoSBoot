package br.com.inforgames.mercadinho.servico.repository;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Produto;

public interface ProdutoRepository {

	Produto save(Produto produto);

	Optional<Produto> findByNome(String nome);

	Optional<Produto> findByBuscarPorNome(String nome);

}
