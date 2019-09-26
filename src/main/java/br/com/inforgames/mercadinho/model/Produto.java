package br.com.inforgames.mercadinho.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pro_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
	private Long id;

	@NotNull(message = "O nome do produto é obrigatório.")
	@Column(name = "pro_nome")
	private String nome;

	@Column(name = "pro_quantidade")
	private int quantidade;

	@Column(name = "pro_preco")
	private BigDecimal preco;

	@Column(name = "pro_tipo_produto")
	private String tipoProduto;

	@Column(name = "pro_marca_produto")
	private String marcaProduto;

	@ManyToOne
	private Fornecedor fornecedor;

	public Produto() {

	}

	public Produto(String nome, int quantidade, BigDecimal preco, String tipoProduto, String marcaProduto,
			Fornecedor fornecedor) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.tipoProduto = tipoProduto;
		this.marcaProduto = marcaProduto;
		this.fornecedor = fornecedor;
	}

	// gets e sets
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
