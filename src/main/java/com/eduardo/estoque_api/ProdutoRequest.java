package com.eduardo.estoque_api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequest(@NotBlank(message = "O Nome é obrigatório ") String nome,
                             @NotNull @Min(value = 1, message = "Precisa ser maior que 0") Integer quantidade) {
}
