package com.dsantosr.productManager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;


}
