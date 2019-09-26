package br.com.inforgames.mercadinho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private Long id;

	@NotNull(message = "O e-mail é obrigatorio.")
	@Size(min = 10, max = 50, message = "O e-mail deve conter entre 10 e 50 caracteres.")
	@Column(name = "usr_email", nullable = false, length = 50)
	private String email;

	@NotNull(message = "A senha é obrigatória.")
	@Size(min = 5, max = 20, message = "A senha deve conter entre 5 e 20 caracteres.")
	@Column(name = "usr_senha", nullable = false, length = 20)
	private String senha;

	// Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmailUsuario(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
