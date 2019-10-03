package br.com.inforgames.mercadinho.servico.dao;

import br.com.inforgames.mercadinho.model.Fornecedor;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeCnpjException;

public interface FornecedorService {

	Fornecedor salvar(Fornecedor fornecedor) throws UnicidadeCnpjException;

}
