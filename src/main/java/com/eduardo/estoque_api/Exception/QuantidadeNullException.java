package com.eduardo.estoque_api.Exception;

public class QuantidadeNullException extends IllegalArgumentException {
    public QuantidadeNullException() {
        super("A Quantidade não pode ser Null!!");
    }
}
