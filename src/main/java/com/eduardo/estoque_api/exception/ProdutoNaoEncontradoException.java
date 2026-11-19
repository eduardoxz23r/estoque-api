package com.eduardo.estoque_api.exception;

public class ProdutoNaoEncontradoException extends IllegalArgumentException {
    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
