package br.com.inforgames.mercadinho.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.inforgames.mercadinho.model.Fornecedor;
import br.com.inforgames.mercadinho.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Iterable<Produto> findByFornecedor(Fornecedor fornecedor);
	Produto findById(long id);
	
}
