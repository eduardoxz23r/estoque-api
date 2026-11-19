package com.eduardo.estoque_api.produto;

import com.eduardo.estoque_api.EstoqueService;
import com.eduardo.estoque_api.ProdutoRepository;
import com.eduardo.estoque_api.exception.ProdutoNaoEncontradoException;
import com.eduardo.estoque_api.ProdutoRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final EstoqueService estoqueService;

    //Injeção de Dependencia
    public ProdutoController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoRequest cadastrar(@RequestBody @Valid ProdutoRequest request) {
        estoqueService.salvar(request.nome(), request.quantidade());
        return request;
    }

    @GetMapping("/{nome}")
    public Integer consultarProduto(@PathVariable String nome) {
        var result = estoqueService.consultar(nome);

        if (result.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado!");
        }
        return result.get();
    }

    @DeleteMapping("/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String nome) {
        estoqueService.deletar(nome);
    }
}
