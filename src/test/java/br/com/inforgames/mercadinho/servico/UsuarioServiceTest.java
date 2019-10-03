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

import br.com.inforgames.mercadinho.model.Usuario;
import br.com.inforgames.mercadinho.servico.dao.UsuarioService;
import br.com.inforgames.mercadinho.servico.exception.UnicidadeEmailException;
import br.com.inforgames.mercadinho.servico.impl.UsuarioServiceImpl;
import br.com.inforgames.mercadinho.servico.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

	private static final String EMAIL = "maycon_gus@gmail.com";
	private static final String SENHA = "1234567890";

	@MockBean
	private UsuarioRepository usuarioRepository;

	private UsuarioService usu;

	private Usuario usuario;

	@Before
	public void setUp() throws Exception {
		usu = new UsuarioServiceImpl(usuarioRepository);

		usuario = new Usuario();
		usuario.setEmailUsuario(EMAIL);
		usuario.setSenha(SENHA);

		when(usuarioRepository.findByEmail(EMAIL)).thenReturn(Optional.empty());

	}

	@Test
	public void deve_salvar_usuario_no_repositorio() throws Exception {
		usu.salvar(usuario);

		verify(usuarioRepository).save(usuario);
	}

	@Test(expected = UnicidadeEmailException.class)
	public void nao_deve_salvar_usuario_no_repositorio_com_mesmo_email() throws Exception {
		when(usuarioRepository.findByEmail(EMAIL)).thenReturn(Optional.of(usuario));

		usu.salvar(usuario);
	}

	@Test
	public void deve_procurar_usuario_por_email() throws Exception {
		when(usuarioRepository.findByBuscarPorEmail(EMAIL)).thenReturn(Optional.of(usuario));

		Usuario usuarioTeste = usu.buscarPorEmail(EMAIL);

		verify(usuarioRepository).findByBuscarPorEmail(EMAIL);

		assertThat(usuarioTeste).isNotNull();
		assertThat(usuarioTeste.getEmail()).isEqualTo(EMAIL);
	}
}
