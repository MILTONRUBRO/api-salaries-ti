package br.com.devmos.apisalariesti.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
}