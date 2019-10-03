package br.com.inforgames.mercadinho.servico.repository;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Cliente;

public interface ClienteRepository {

	Cliente save(Cliente cliente);

	Optional<Cliente> findByCpf(String cpf);

	Optional<Cliente> findBybuscarPorNome(String nome);

}
