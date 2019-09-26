package br.com.inforgames.mercadinho.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cli_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_id")
	private Long id;

	@Column(name = "cli_nome", length = 50, nullable = false)
	@Size(max = 100)
	@NotNull(message = "O nome do cliente é obrigatório.")
	private String nome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cli_data_abertura", nullable = false)
	private Date dataAbertura;

	@Column(name = "cli_cpf", nullable = false)
	@NotNull(message = "O CPF do cliente é obrigatório")
	private String cpf;

	@Column(name = "cli_email", nullable = false)
	private String email;

	@Column(name = "cli_telefone")
	private String telefone;

	@Embedded
	private Endereco endereco = new Endereco();

	public Cliente() {
		
	}

	public Cliente(String nome, Date dataAbertura, String cpf, String email, String telefone, Endereco endereco) {
		this.nome = nome;
		this.dataAbertura = dataAbertura;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
