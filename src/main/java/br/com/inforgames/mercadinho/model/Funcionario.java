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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "fun_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fun_id")
	private Long id;

	@Column(name = "fun_nome")
	@NotNull(message = "O nome do funcionario é obrigatório")
	private String nome;

	@Column(name = "fun_cpf")
	@NotNull(message = "O CPF do funcionario é obrigatório.")
	private String cpf;

	@Column(name = "fun_salario")
	private Double salario;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fum_data_admissao")
	private Date dataAdmissao;

	@Column(name = "fun_email")
	private String email;

	@Column(name = "fun_telefone")
	private String telefone;

	@Embedded
	private Endereco endereco = new Endereco();

	public Funcionario() {

	}

	public Funcionario(String nome, String cpf, Double salario, Date dataAdmissao, String email, String telefone,
			Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
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
