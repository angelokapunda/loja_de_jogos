package com.generation.loja_jogos.repository;

import com.generation.loja_jogos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findAllByNomeContaining(String nome);
}
