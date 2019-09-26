package br.com.inforgames.mercadinho.servico.impl;

import br.com.inforgames.mercadinho.model.Cliente;
import br.com.inforgames.mercadinho.servico.dao.ClienteService;
import br.com.inforgames.mercadinho.servico.repository.ClienteRepository;

public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Cliente salvar(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}
}
