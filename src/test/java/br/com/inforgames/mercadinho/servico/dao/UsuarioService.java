package br.com.inforgames.mercadinho.servico.dao;

import br.com.inforgames.mercadinho.model.Usuario;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeEmailException;

public interface UsuarioService {

	Usuario salvar(Usuario usuario) throws UnicidadeEmailException;
	
}
