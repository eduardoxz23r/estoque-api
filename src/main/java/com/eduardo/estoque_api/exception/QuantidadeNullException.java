package com.eduardo.estoque_api.exception;

public class QuantidadeNullException extends IllegalArgumentException {
    public QuantidadeNullException() {
        super("A Quantidade não pode ser Null!!");
    }
}
