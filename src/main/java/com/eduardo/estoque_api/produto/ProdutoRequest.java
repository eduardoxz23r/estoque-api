package com.eduardo.estoque_api.produto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProdutoRequest(@NotBlank(message = "O Nome é obrigatório") @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres") String nome,
                             @NotNull(message = "A Quantidade não pode ser Null") @Min(value = 1, message = "Precisa ser maior que 0") Integer quantidade) {
}
