package br.com.inforgames.mercadinho.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.inforgames.mercadinho.model.Fornecedor;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {

	Fornecedor findById(long id);
	
}
