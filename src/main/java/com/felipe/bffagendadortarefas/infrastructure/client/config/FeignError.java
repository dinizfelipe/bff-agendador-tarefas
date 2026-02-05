package com.felipe.bffagendadortarefas.infrastructure.client.config;

import com.felipe.bffagendadortarefas.infrastructure.exceptions.BusinessException;
import com.felipe.bffagendadortarefas.infrastructure.exceptions.ConflictException;
import com.felipe.bffagendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.felipe.bffagendadortarefas.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 409:
                return new ConflictException("Erro! Atributo já existente.");
            case 403:
                return new ResourceNotFoundException("Erro! Atributo não encontrado.");
            case 401:
                return new UnauthorizedException("Erro! Usuário não autorizado.");
            default:
                return new BusinessException("Erro de servidor.");
        }
    }
}
