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

import br.com.inforgames.mercadinho.model.Cliente;
import br.com.inforgames.mercadinho.servico.dao.ClienteService;
import br.com.inforgames.mercadinho.servico.exception.ClienteNaoEncontradoException;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeCpfException;
import br.com.inforgames.mercadinho.servico.impl.ClienteServiceImpl;
import br.com.inforgames.mercadinho.servico.repository.ClienteRepository;

@RunWith(SpringRunner.class)
public class ClienteServiceTest {

	private static final String CPF = "12345678912";
	private static final String NOME = "Maycon Santana";
	private static final String EMAIL = "mrs_2000@hotmail.com";
	private static final String TELEFONE = "99-99999-9999";

	@MockBean
	private ClienteRepository clienteRepository;

	private ClienteService cli;

	private Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cli = new ClienteServiceImpl(clienteRepository);

		cliente = new Cliente();
		cliente.setNome(NOME);
		cliente.setCpf(CPF);
		cliente.setEmail(EMAIL);
		cliente.setTelefone(TELEFONE);

		when(clienteRepository.findByCpf(CPF)).thenReturn(Optional.empty());
	}

	@Test
	public void deve_salvar_cliente_no_repositorio() throws Exception {
		cli.salvar(cliente);

		verify(clienteRepository).save(cliente);
	}

	@Test(expected = UnicidadeCpfException.class)
	public void nao_deve_salvar_dois_clientes_com_o_mesmo_cpf() throws Exception {
		when(clienteRepository.findByCpf(CPF)).thenReturn(Optional.of(cliente));

		cli.salvar(cliente);
	}

	@Test
	public void deve_procurar_cliente_pelo_nome() throws Exception {
		when(clienteRepository.findBybuscarPorNome(NOME)).thenReturn(Optional.of(cliente));

		Cliente clienteTeste = cli.buscarPorNome(NOME);

		verify(clienteRepository).findBybuscarPorNome(NOME);

		assertThat(clienteTeste).isNotNull();
		assertThat(clienteTeste.getNome()).isEqualTo(NOME);
		assertThat(clienteTeste.getCpf()).isEqualTo(CPF);
	}

}
