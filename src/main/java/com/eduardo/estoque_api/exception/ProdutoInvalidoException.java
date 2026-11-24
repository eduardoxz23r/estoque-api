package com.eduardo.estoque_api.exception;

public class ProdutoInvalidoException extends IllegalArgumentException {
    public ProdutoInvalidoException() {
        super("Produto Inválido!!");
    }
}
