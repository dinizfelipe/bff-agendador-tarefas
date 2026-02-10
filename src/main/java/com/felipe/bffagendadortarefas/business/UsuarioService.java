package com.felipe.bffagendadortarefas.business;


import com.felipe.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.felipe.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.felipe.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.felipe.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.felipe.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.felipe.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.felipe.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.felipe.bffagendadortarefas.infrastructure.client.UsuarioClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsaurio(String token, UsuarioDTORequest dto) {
        return usuarioClient.atualizaDadosUsuario(dto, token);

    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token) {
        return usuarioClient.atualizaEndereco(enderecoDTO, idEndereco, token);

    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token) {
        return usuarioClient.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto) {
        return usuarioClient.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto) {
        return usuarioClient.cadastraTelefone(dto, token);
    }

}
