package br.com.inforgames.mercadinho.servico.repository;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Funcionario;

public interface FuncionarioRepository {

	Funcionario save(Funcionario funcionario);

	Optional<Funcionario> findByCpf(String cpf);

}
