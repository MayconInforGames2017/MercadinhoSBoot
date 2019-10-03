package br.com.inforgames.mercadinho.servico.impl;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Cliente;
import br.com.inforgames.mercadinho.servico.dao.ClienteService;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeCpfException;
import br.com.inforgames.mercadinho.servico.repository.ClienteRepository;

public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Cliente salvar(Cliente cliente) throws UnicidadeCpfException {
		Optional<Cliente> optional = clienteRepository.findByCpf(cliente.getCpf());

		if (optional.isPresent()) {
			throw new UnicidadeCpfException();
		}

		return clienteRepository.save(cliente);
	}

}
