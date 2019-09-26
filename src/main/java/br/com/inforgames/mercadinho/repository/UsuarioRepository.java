package br.com.inforgames.mercadinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inforgames.mercadinho.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
	
}
