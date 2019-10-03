package br.com.inforgames.mercadinho.servico;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.inforgames.mercadinho.model.Fornecedor;
import br.com.inforgames.mercadinho.servico.dao.FornecedorService;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeCnpjException;
import br.com.inforgames.mercadinho.servico.impl.FornecedorServiceImpl;
import br.com.inforgames.mercadinho.servico.repository.FornecedorRepository;

@RunWith(SpringRunner.class)
public class FornecedorServiceTest {

	private static final String CNPJ = "";
	private static final String NOME = "Atacadão";
	private static final String TELEFONE = "99-99999-9998";

	@MockBean
	private FornecedorRepository fornecedorRepository;

	private FornecedorService forn;

	private Fornecedor fornecedor;

	@Before
	public void setUp() throws Exception {
		forn = new FornecedorServiceImpl(fornecedorRepository);

		fornecedor = new Fornecedor();
		fornecedor.setNome(NOME);
		fornecedor.setCnpj(CNPJ);
		fornecedor.setTelefone(TELEFONE);

		when(fornecedorRepository.findByCnpj(CNPJ)).thenReturn(Optional.empty());
	}

	@Test
	public void deve_salvar_fornecedor_no_repositorio() throws Exception {
		forn.salvar(fornecedor);

		verify(fornecedorRepository).save(fornecedor);
	}

	@Test(expected = UnicidadeCnpjException.class)
	public void nao_deve_salvar_dois_fornecedores_com_o_mesmo_cnpj() throws Exception {
		when(fornecedorRepository.findByCnpj(CNPJ)).thenReturn(Optional.of(fornecedor));

		forn.salvar(fornecedor);
	}

}
