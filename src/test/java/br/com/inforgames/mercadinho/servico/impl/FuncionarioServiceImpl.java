package br.com.inforgames.mercadinho.servico.impl;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Funcionario;
import br.com.inforgames.mercadinho.servico.dao.FuncionarioService;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeCpfException;
import br.com.inforgames.mercadinho.servico.repository.FuncionarioRepository;

public class FuncionarioServiceImpl implements FuncionarioService {

	private FuncionarioRepository funcionarioRepository;

	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public Funcionario salvar(Funcionario funcionario) throws UnicidadeCpfException {
		Optional<Funcionario> optional = funcionarioRepository.findByCpf(funcionario.getCpf());

		if (optional.isPresent()) {
			throw new UnicidadeCpfException();
		}

		return funcionarioRepository.save(funcionario);
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return funcionarioRepository.findByBuscarPorCpf(cpf).get();
	}

}
