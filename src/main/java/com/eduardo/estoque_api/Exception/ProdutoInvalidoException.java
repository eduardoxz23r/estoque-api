package com.eduardo.estoque_api.Exception;

public class ProdutoInvalidoException extends RuntimeException {
    public ProdutoInvalidoException() {
        super("O Produto não pode ser Null!!");
    }
}
