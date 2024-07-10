DROP TABLE IF EXISTS pedidos;
CREATE TABLE pedidos(
    pedido_id INT PRIMARY KEY
);

DROP TABLE IF EXISTS produtos;
CREATE TABLE produtos(
     produto_id INT PRIMARY KEY,
     nome VARCHAR(30) NOT NULL,
     desc VARCHAR(255) NOT NULL,
     preco DECIMAL(7,2) NOT NULL,
     quantidade INT NOT NULL,
     pedido_id INT NOT NULL,
     foreign key (pedido_id) references pedidos(pedido_id)
);