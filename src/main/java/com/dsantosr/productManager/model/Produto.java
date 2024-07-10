package com.dsantosr.productManager.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of="id")

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEmEstoque;

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;
}