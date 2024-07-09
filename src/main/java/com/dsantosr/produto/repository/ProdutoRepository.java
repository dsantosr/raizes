package com.dsantosr.produto.repository;

import com.dsantosr.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProdutoRepository<T, ID extends Serializable> extends JpaRepository<Produto, Long> {

}