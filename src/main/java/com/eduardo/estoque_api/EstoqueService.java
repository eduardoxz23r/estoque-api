package com.eduardo.estoque_api;

import com.eduardo.estoque_api.Exception.ProdutoInvalidoException;
import com.eduardo.estoque_api.Exception.ProdutoNaoEncontradoException;
import com.eduardo.estoque_api.Exception.QuantidadeInvalidaException;
import com.eduardo.estoque_api.Exception.QuantidadeNullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class EstoqueService {

    Map<String, Integer> list = new HashMap<>();

    public void salvar(String produto, Integer quantidade) {
        if (produto == null || produto.isBlank()) {
            throw new ProdutoInvalidoException();
        }
        var total = quantidade;

        if (quantidade == null) {
            throw new QuantidadeNullException();
        }

        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException();
        }

        if (list.containsKey(produto)) {
            total += list.get(produto);
        }

        list.put(produto, total);
    }

    public Optional<Integer> consultar(String produto) {
        return Optional.ofNullable(list.get(produto));
    }

    public void deletar(String produto) {
        if (!list.containsKey(produto)) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado: " + produto);
        }
        list.remove(produto);
    }
}
