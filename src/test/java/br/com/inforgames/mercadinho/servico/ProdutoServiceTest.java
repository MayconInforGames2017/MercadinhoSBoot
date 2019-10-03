package br.com.inforgames.mercadinho.servico;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.inforgames.mercadinho.model.Produto;
import br.com.inforgames.mercadinho.servico.dao.ProdutoService;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeNomeException;
import br.com.inforgames.mercadinho.servico.impl.ProdutoServiceImpl;
import br.com.inforgames.mercadinho.servico.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
public class ProdutoServiceTest {

	private static final String NOME = "Acucar";
	private static final int QUANTIDADE = 100;
	// private static final double PRECO = 2.90;
	private static final String TIPO_PRODUTO = "Cereais";
	private static final String MARCA_PRODUTO = "Aza Branca";

	@MockBean
	private ProdutoRepository produtoRepository;

	private ProdutoService prod;

	private Produto produto;

	@Before
	public void setUp() throws Exception {
		prod = new ProdutoServiceImpl(produtoRepository);

		produto = new Produto();
		produto.setNome(NOME);
		produto.setQuantidade(QUANTIDADE);
		// produto.setPreco(PRECO);
		produto.setMarcaProduto(MARCA_PRODUTO);
		produto.setTipoProduto(TIPO_PRODUTO);

		when(produtoRepository.findByNome(NOME)).thenReturn(Optional.empty());
	}

	@Test
	public void deve_salvar_produto_no_repositorio() throws Exception {
		prod.salvar(produto);

		verify(produtoRepository).save(produto);

	}

	@Test(expected = UnicidadeNomeException.class)
	public void nao_deve_salvar_produto_no_repositorio() throws Exception {
		when(produtoRepository.findByNome(NOME)).thenReturn(Optional.of(produto));

		prod.salvar(produto);
	}

	@Test
	public void deve_procurar_produto_pelo_nome() throws Exception {
		when(produtoRepository.findByBuscarPorNome(NOME)).thenReturn(Optional.of(produto));
		
		Produto produtoTeste = prod.buscarPorNome(NOME);
		
		verify(produtoRepository).findByBuscarPorNome(NOME);
		
		assertThat(produtoTeste).isNotNull();
		assertThat(produtoTeste.getNome()).isEqualTo(NOME);
	}
}
