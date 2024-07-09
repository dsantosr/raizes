package com.dsantosr.produto.repository;

import com.dsantosr.produto.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface PedidoRepository<T, ID extends Serializable> extends JpaRepository<Pedido, Long> {

}