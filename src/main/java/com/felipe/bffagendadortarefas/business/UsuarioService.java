package com.felipe.bffagendadortarefas.business;


import com.felipe.bffagendadortarefas.business.dto.EnderecoDTO;
import com.felipe.bffagendadortarefas.business.dto.TelefoneDTO;
import com.felipe.bffagendadortarefas.business.dto.UsuarioDTO;
import com.felipe.bffagendadortarefas.infrastructure.client.UsuarioClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(UsuarioDTO usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }

    public UsuarioDTO buscaUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizaDadosUsaurio(String token, UsuarioDTO dto) {
        return usuarioClient.atualizaDadosUsuario(dto, token);

    }

    public EnderecoDTO atualizaEndereco(Long idEndereco, EnderecoDTO enderecoDTO, String token) {
        return usuarioClient.atualizaEndereco(enderecoDTO, idEndereco, token);

    }

    public TelefoneDTO atualizaTelefone(Long idTelefone, TelefoneDTO dto, String token) {
        return usuarioClient.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTO cadastraEndereco(String token, EnderecoDTO dto) {
        return usuarioClient.cadastraEndereco(dto, token);
    }

    public TelefoneDTO cadastraTelefone(String token, TelefoneDTO dto) {
        return usuarioClient.cadastraTelefone(dto, token);
    }

}
