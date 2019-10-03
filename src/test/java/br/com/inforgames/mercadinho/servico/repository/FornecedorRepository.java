package br.com.inforgames.mercadinho.servico.repository;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Fornecedor;

public interface FornecedorRepository {

	Fornecedor save(Fornecedor fornecedor);

	Optional<Fornecedor> findByCnpj(String cnpj);

}
