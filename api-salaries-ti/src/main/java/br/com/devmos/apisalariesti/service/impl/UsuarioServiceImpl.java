package br.com.devmos.apisalariesti.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.devmos.apisalariesti.exceptions.UsuarioNaoEncontradoException;
import br.com.devmos.apisalariesti.model.Usuario;
import br.com.devmos.apisalariesti.model.UsuarioDTO;
import br.com.devmos.apisalariesti.model.parser.UsuarioDTOParser;
import br.com.devmos.apisalariesti.model.request.UsuarioRequestDTO;
import br.com.devmos.apisalariesti.repository.UsuarioRepository;

@Component
public class UsuarioServiceImpl {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;


	public UsuarioDTO salvar(UsuarioRequestDTO user) {
		user.setPass(encoder.encode(user.getPass()));
		return UsuarioDTOParser.toUsuarioDTO(usuarioRepository.save(UsuarioDTOParser.toUsuarioEntity(user)));
	}

	public List<UsuarioDTO> findAll() {
		return usuarioRepository.findAll().stream().map(UsuarioDTOParser::toUsuarioDTO).collect(Collectors.toList());
	}

	public UsuarioDTO findById(Long id) {
		Usuario user = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário de ID " + id + " não encontrado."));

		return UsuarioDTOParser.toUsuarioDTO(user);
	}

	public UsuarioDTO atualizar(UsuarioRequestDTO usuario, Long id) {
		findById(id);
		Usuario usuarioEntity = UsuarioDTOParser.toUsuarioEntity(usuario);
		usuarioEntity.setId(id);

		return UsuarioDTOParser.toUsuarioDTO(usuarioRepository.save(usuarioEntity));

	}

	public void deletar(Long id) {
		findById(id);
		usuarioRepository.deleteById(id);
	}

}
