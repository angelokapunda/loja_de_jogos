package com.generation.loja_jogos.controller;

import com.generation.loja_jogos.model.Produto;
import com.generation.loja_jogos.service.CadastroProduto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private CadastroProduto cadastro;

    @PostMapping
    public ResponseEntity<Produto> save (@Valid @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cadastro.save(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok().body(cadastro.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(cadastro.getId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getAllNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(cadastro.getAllNomeProduto(nome));
    }

    @GetMapping("/maior-preco/{preco}")
    public ResponseEntity<List<Produto>> maiorPreco(@PathVariable BigDecimal preco) {
        return ResponseEntity.ok().body(cadastro.maiorPreco(preco));
    }

    @GetMapping("/menor-preco/{preco}")
    public ResponseEntity<List<Produto>> menorPreco(@PathVariable BigDecimal preco) {
        return ResponseEntity.ok().body(cadastro.menorPreco(preco));
    }

    @PutMapping
    public ResponseEntity<Produto> put (@Valid @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cadastro.update(produto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) {
        cadastro.delete(id);
    }

}
