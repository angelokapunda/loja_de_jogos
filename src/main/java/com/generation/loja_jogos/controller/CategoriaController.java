package com.generation.loja_jogos.controller;

import com.generation.loja_jogos.model.Categoria;
import com.generation.loja_jogos.service.CadastroCategoria;
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

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CadastroCategoria cadastro;

    @PostMapping
    public ResponseEntity<Categoria> save (@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cadastro.save(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok().body(cadastro.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(cadastro.getId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Categoria>> getAllNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(cadastro.getAllNome(nome));
    }

    @PutMapping
    public ResponseEntity<Categoria> put (@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cadastro.update(categoria));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) {
        cadastro.delete(id);
    }
}
