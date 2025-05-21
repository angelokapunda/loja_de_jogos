package com.generation.loja_jogos.service;

import com.generation.loja_jogos.model.Categoria;
import com.generation.loja_jogos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CadastroCategoria {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save (Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update (Categoria categoria) {
        if (categoria.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID é obrigatória para a Ctualização");
        }
        return save(categoria);
    }

    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Categoria getId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "A Categoria de ID " + id + " não existe"));
    }

    public List<Categoria> getAllNome(String nome) {
        return categoriaRepository.findAllByNomeContaining(nome);
    }

    public void delete(Long id) {
        var categoriaId = getId(id);
        if (categoriaId != null) {
            categoriaRepository.delete(categoriaId);
        }
    }
}
