package br.com.inforgames.mercadinho.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "for_fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "for_id")
	private Long id_For;

	@NotNull(message = "O nome do fornecedor é obrigatório.")
	@Size(max = 100, message = "O nome do fornecedor deve conter até 100 caracteres.")
	@Column(name = "for_nome")
	private String nome;

	@NotNull(message = "O CNPJ é obrigatório.")
	@Column(name = "for_cnpj")
	private String cnpj;

	@Column(name = "for_telefone")
	private String Telefone;

	@Embedded
	private Endereco Endereco = new Endereco();

	@OneToMany
	private List<Produto> produtos;

	public Fornecedor() {

	}

	public Fornecedor(String nome, String cnpj, String telefone, Endereco endereco, List<Produto> produtos) {
		this.nome = nome;
		this.cnpj = cnpj;
		Telefone = telefone;
		Endereco = endereco;
		this.produtos = produtos;
	}

	public Long getId_For() {
		return id_For;
	}

	public void setId(Long id_For) {
		this.id_For = id_For;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public Endereco getEndereco() {
		return Endereco;
	}

	public void setEndereco(Endereco endereco) {
		Endereco = endereco;
	}

	public List<Produto> getListaProdutos() {
		return produtos;
	}

	public void setListaProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
