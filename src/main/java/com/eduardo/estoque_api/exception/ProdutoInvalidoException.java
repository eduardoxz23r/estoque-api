package com.eduardo.estoque_api.exception;

public class ProdutoInvalidoException extends RuntimeException {
    public ProdutoInvalidoException() {
        super("O Produto não pode ser Null!!");
    }
}
