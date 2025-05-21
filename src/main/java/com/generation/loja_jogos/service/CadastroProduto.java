package com.generation.loja_jogos.service;

import com.generation.loja_jogos.model.Produto;
import com.generation.loja_jogos.repository.CategoriaRepository;
import com.generation.loja_jogos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CadastroProduto {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto save (Produto produto) {
        if (!categoriaRepository.existsById(produto.getCategoria().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A Categoria não existe");
        }
        return produtoRepository.save(produto);
    }

    public Produto update (Produto produto) {
         if (produto.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID é obrigatória para a Actualização");
        }
        return save(produto);
    }

    public List<Produto> getAll () {
        return produtoRepository.findAll();
    }

    public Produto getId(Long id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Produto de ID " + id + " não existe"));
    }

    public List<Produto> getAllNomeProduto(String nome) {
        return produtoRepository.findAllByNomeContaining(nome);
    }

    public List<Produto> maiorPreco(BigDecimal preco) {
        return produtoRepository.findByPrecoGreaterThan(preco);
    }

    public List<Produto> menorPreco(BigDecimal preco) {
        return produtoRepository.findByPrecoLessThan(preco);
    }

    public void delete(Long id) {
        var produtoId = getId(id);
        if (produtoId != null) {
            produtoRepository.delete(produtoId);
        }
    }

}
