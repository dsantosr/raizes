package com.dsantosr.productManager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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


    @OneToMany(mappedBy = "produto_id", cascade = CascadeType.ALL)
    private Set<ItemPedido> items = new HashSet<>();

}