# Aplicação de Gerenciamento de Produtos e Pedidos
## Introdução

Desafio: Fazer uma aplicação REST simples que gerencie informações sobre produtos. A aplicação deve permitir a criação, atualização, remoção e consulta de produtos, além de criar pedidos para serem expedidos, movimentando o estoque do produto no sistema.

## Requisitos Funcionais

- A aplicação deve permitir a criação de um novo produto com os seguintes dados: nome, descrição, preço e quantidade em estoque.
- A aplicação deve permitir a atualização dos dados de um produto existente.
- A aplicação deve permitir a remoção de um produto existente.
- A aplicação deve permitir a consulta de todos os produtos cadastrados, bem como a consulta de um produto específico por ID.
- A aplicação deve permitir criar um pedido para ser expedido, movimentando o estoque do produto no sistema.
- Todos os endpoints devem seguir as boas práticas RESTful.

## Requisitos Técnicos

- Spring Boot para criar a aplicação.
- Banco de dados em memória (por exemplo, H2) para armazenar os dados dos produtos.
- Padrão DAO (Data Access Object) para realizar operações no banco de dados.
- Testes unitários para os serviços de criação, atualização, remoção e consulta de produtos.
- Swagger na aplicação, expondo todos os endpoints para serem testados.

## Configuração do Projeto
Pré-requisitos

1. Java 17 ou superior
2. Maven

### Configuração

1. Clone o repositório:

```bash
git@github.com:dsantosr/raizes.git
cd raizes
```

2. Construa o projeto:
   
```bash
mvn clean install
```

3. Execute a aplicação:
   
```bash
mvn spring-boot:run
```

## Configuração do Banco de Dados
A aplicação utiliza o banco de dados em memória H2. A configuração pode ser encontrada em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

## Endpoints da API

### Produtos
* `GET /produtos` : Lista todos os produtos
* `GET /produtos/{id}` : Obtém um produto por ID
* `POST /produtos` : Cria um novo produto
* `PUT /produtos/{id}` : Atualiza um produto existente
* `DELETE /produtos/{id}` : Remove um produto

### Pedidos
* `GET /pedidos` : Lista todos os pedidos
* `GET /pedidos/{id}` : Obtem um pedido por ID
* `POST /pedidos` : Cria um novo pedido
* `PUT /pedidos/{id}` : Atualiza um pedido existente
* `DELETE /pedidos/{id}` : Remove um pedido

  
### ItemPedido
* `POST /itempedido/{pedido_id}/{produto_id}/{quantidade}` : Cria um novo pedido

## Executando Testes
Para executar os testes unitários, utilize o comando:
```
mvn test
```
