package br.com.inforgames.mercadinho.servico.dao;

import br.com.inforgames.mercadinho.model.Funcionario;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeCpfException;

public interface FuncionarioService {

	Funcionario salvar(Funcionario funcionario) throws UnicidadeCpfException;

}
