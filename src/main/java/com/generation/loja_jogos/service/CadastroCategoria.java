package com.generation.loja_jogos.service;

import com.generation.loja_jogos.model.Categoria;
import com.generation.loja_jogos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroCategoria {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save (Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Categoria getId(Long id) {
        return categoriaRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        var categoriaId = getId(id);
        if (categoriaId != null) {
            categoriaRepository.delete(categoriaId);
        }
    }
}
