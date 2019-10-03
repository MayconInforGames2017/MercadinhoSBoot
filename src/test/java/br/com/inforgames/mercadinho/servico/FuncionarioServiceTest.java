package br.com.inforgames.mercadinho.servico;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.inforgames.mercadinho.model.Funcionario;
import br.com.inforgames.mercadinho.servico.dao.FuncionarioService;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeCpfException;
import br.com.inforgames.mercadinho.servico.impl.FuncionarioServiceImpl;
import br.com.inforgames.mercadinho.servico.repository.FuncionarioRepository;

@RunWith(SpringRunner.class)
public class FuncionarioServiceTest {

	private static final String CPF = "12345678901";
	private static final String NOME = "João";
	private static final String EMAIL = "joao_gus@hotmail.com";
	private static final String TELEFONE = "88-88888-8888";

	@MockBean
	private FuncionarioRepository funcionarioRepostitory;

	private FuncionarioService fun;

	private Funcionario funcionario;

	@Before
	public void setUp() throws Exception {
		fun = new FuncionarioServiceImpl(funcionarioRepostitory);

		funcionario = new Funcionario();
		funcionario.setNome(NOME);
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setTelefone(TELEFONE);

		when(funcionarioRepostitory.findByCpf(CPF)).thenReturn(Optional.empty());
	}

	@Test
	public void deve_salvar_funcionario_no_repositorio() throws Exception {
		fun.salvar(funcionario);

		verify(funcionarioRepostitory).save(funcionario);
	}

	@Test(expected = UnicidadeCpfException.class)
	public void nao_deve_salvar_dois_clientes_com_mesmo_cpf() throws Exception {
		when(funcionarioRepostitory.findByCpf(CPF)).thenReturn(Optional.of(funcionario));

		fun.salvar(funcionario);
	}
}
