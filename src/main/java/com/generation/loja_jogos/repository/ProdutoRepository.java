package com.generation.loja_jogos.repository;

import com.generation.loja_jogos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
