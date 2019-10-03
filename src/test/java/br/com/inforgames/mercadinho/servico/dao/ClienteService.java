package br.com.inforgames.mercadinho.servico.dao;

import br.com.inforgames.mercadinho.model.Cliente;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeCpfException;

public interface ClienteService {

	Cliente salvar(Cliente cliente) throws UnicidadeCpfException;

	Cliente buscarPorNome(String nome);

}
