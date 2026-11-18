package com.eduardo.estoque_api.Exception;

public class QuantidadeInvalidaException extends IllegalArgumentException {
    public QuantidadeInvalidaException() {
        super("O Produto não pode ser menor que zero!!");
    }
}
