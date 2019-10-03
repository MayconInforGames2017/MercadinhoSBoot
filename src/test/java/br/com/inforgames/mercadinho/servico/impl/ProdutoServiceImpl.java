package br.com.inforgames.mercadinho.servico.impl;

import java.util.Optional;

import br.com.inforgames.mercadinho.model.Produto;
import br.com.inforgames.mercadinho.servico.dao.ProdutoService;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeNomeException;
import br.com.inforgames.mercadinho.servico.repository.ProdutoRepository;

public class ProdutoServiceImpl implements ProdutoService {

	private ProdutoRepository produtoRepository;

	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public Produto salvar(Produto produto) throws UnicidadeNomeException {
		Optional<Produto> optional = produtoRepository.findByNome(produto.getNome());

		if (optional.isPresent()) {
			throw new UnicidadeNomeException();
		}

		return produtoRepository.save(produto);
	}

	@Override
	public Produto buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return produtoRepository.findByBuscarPorNome(nome).get();
	}

}
