package com.eduardo.estoque_api.Exception;

public class ProdutoNaoEncontradoException extends IllegalArgumentException {
    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
