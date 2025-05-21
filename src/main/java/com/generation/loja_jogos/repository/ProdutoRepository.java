package com.generation.loja_jogos.repository;

import com.generation.loja_jogos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByNomeContaining(String nome);
}
