package br.com.inforgames.mercadinho.servico.impl;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Usuario;
import br.com.inforgames.mercadinho.servico.dao.UsuarioService;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeEmailException;
import br.com.inforgames.mercadinho.servico.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario salvar(Usuario usuario) throws UnicidadeEmailException {
		Optional<Usuario> optional = usuarioRepository.findByEmail(usuario.getEmail());

		if (optional.isPresent()) {
			throw new UnicidadeEmailException();
		}

		return usuarioRepository.save(usuario);
	}

}
