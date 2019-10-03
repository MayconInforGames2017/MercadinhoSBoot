package br.com.inforgames.mercadinho.servico.impl;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Fornecedor;
import br.com.inforgames.mercadinho.servico.repository.FornecedorRepository;
import br.com.inforgames.mercadinho.servico.dao.FornecedorService;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeCnpjException;

public class FornecedorServiceImpl implements FornecedorService {

	private FornecedorRepository fornecedorRepository;

	public FornecedorServiceImpl(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	@Override
	public Fornecedor salvar(Fornecedor fornecedor) throws UnicidadeCnpjException {
		Optional<Fornecedor> optional = fornecedorRepository.findByCnpj(fornecedor.getCnpj());

		if (optional.isPresent()) {
			throw new UnicidadeCnpjException();
		}

		return fornecedorRepository.save(fornecedor);
	}

}
