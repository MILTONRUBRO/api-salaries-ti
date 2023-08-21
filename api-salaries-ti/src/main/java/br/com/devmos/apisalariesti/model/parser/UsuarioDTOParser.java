package br.com.devmos.apisalariesti.model.parser;

import br.com.devmos.apisalariesti.model.Usuario;
import br.com.devmos.apisalariesti.model.UsuarioDTO;
import br.com.devmos.apisalariesti.model.request.UsuarioRequestDTO;

public class UsuarioDTOParser {
	
    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(usuario.getEmail());
        dto.setNome(usuario.getNome());
        dto.setId(usuario.getId());
        return dto;
    }

    public static UsuarioRequestDTO toUsuarioRequestDTO(Usuario user) {
    	UsuarioRequestDTO dto = new UsuarioRequestDTO();
        dto.setPass(user.getPassword());
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static Usuario toUsuarioEntity(UsuarioRequestDTO dto) {
        Usuario entity = new Usuario();
        entity.setPassword(dto.getPass());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        return entity;
    }

}
