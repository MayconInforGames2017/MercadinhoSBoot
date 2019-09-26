package br.com.inforgames.mercadinho.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column(name = "end_numero_imovel")
	private int numeroImovel;

	@Column(name = "end_logradouro")
	private String logradouro;

	@Column(name = "end_bairro")
	private String bairro;

	@Column(name = "end_cep")
	private String cep;

	@Column(name = "end_cidade")
	private String cidade;

	@Column(name = "end_uf")
	private String uf;

	public Endereco() {

	}

	public Endereco(int numeroImovel, String logradouro, String bairro, 
					String cep, String cidade, String uf) {
		this.numeroImovel = numeroImovel;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public int getNumeroImovel() {
		return numeroImovel;
	}

	public void setNumeroImovel(int numeroImovel) {
		this.numeroImovel = numeroImovel;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
