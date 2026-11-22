package com.eduardo.estoque_api;

import com.eduardo.estoque_api.exception.ProdutoInvalidoException;
import com.eduardo.estoque_api.exception.ProdutoNaoEncontradoException;
import com.eduardo.estoque_api.exception.QuantidadeInvalidaException;
import com.eduardo.estoque_api.exception.QuantidadeNullException;
import com.eduardo.estoque_api.produto.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    private final ProdutoRepository produtoRepository;

    public EstoqueService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void salvar(String produto, Integer quantidade) {
        if (produto == null || produto.isBlank()) {
            throw new ProdutoInvalidoException();
        }

        if (quantidade == null) {
            throw new QuantidadeNullException();
        }

        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException();
        }

        var existente = produtoRepository.findByNome(produto);

        if (existente.isPresent()) {
            existente.get().setQuantidade(existente.get().getQuantidade() + quantidade);
            produtoRepository.save(existente.get());
        } else {
            Produto newProduto = new Produto();
            newProduto.setNome(produto);
            newProduto.setQuantidade(quantidade);
            produtoRepository.save(newProduto);
        }
    }

    public Optional<Integer> consultar(String produto) {
        return produtoRepository.findByNome(produto)
                .map(Produto::getQuantidade);
    }

    public void deletar(String produto) {
        //Procura o produto.
        var procurar = produtoRepository.findByNome(produto);

        //Se procurar estiver vazio, lance o erro, se não, apague no banco de dados.
        if (procurar.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado!");
        }
        produtoRepository.delete(procurar.get());
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public void atualizar(String produto, Integer quantidade) {

        var result = produtoRepository.findByNome(produto);

        if (result.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado!");
        }

        result.get().setQuantidade(quantidade);
        produtoRepository.save(result.get());
    }
}
