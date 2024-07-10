package com.dsantosr.productManager.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of="id")
@NoArgsConstructor

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="pedido")
    private List<Produto> produtos = new ArrayList<>();

    public Pedido(Long id) {
        this.id = id;
    }
}