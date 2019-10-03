package br.com.inforgames.mercadinho.servico.repository;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Usuario;

public interface UsuarioRepository {

	Usuario save(Usuario usuario);

	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findByBuscarPorEmail(String email);

}
