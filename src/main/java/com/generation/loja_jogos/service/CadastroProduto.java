package com.generation.loja_jogos.service;

import com.generation.loja_jogos.model.Produto;
import com.generation.loja_jogos.repository.CategoriaRepository;
import com.generation.loja_jogos.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CadastroProduto {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Produto save (Produto produto) {
        if (!categoriaRepository.existsById(produto.getCategoria().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A Categoria não existe");
        }
        return produtoRepository.save(produto);
    }

    public List<Produto> getAll () {
        return produtoRepository.findAll();
    }

    public Produto getId(Long id) {
        return produtoRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        var produtoId = getId(id);
        if (produtoId != null) {
            produtoRepository.delete(produtoId);
        }
    }

}
