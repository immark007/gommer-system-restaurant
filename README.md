# Goomer System Restaurant - API Documentation

## Introdução
O **Goomer System Restaurant** é um sistema de gerenciamento de restaurantes desenvolvido com **Spring Boot** e **PostgreSQL**. A API permite a gestão de usuários, restaurantes e produtos, oferecendo endpoints para criação, edição, busca e remoção de entidades.

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL** (via **Docker Compose**)
- **Flyway** (para migração do banco de dados)
- **Springdoc OpenAPI** (para documentação da API - ainda precisa ser implementado)
- **OAuth2 com JWT** (para autenticação - ainda precisa ser implementado)

## Configuração do Ambiente

1. Clone o repositório:
   ```sh
   git clone https://github.com/immark007/gommer-system-restaurant.git
   cd gommer-system-restaurant
   ```

2. Suba o banco de dados PostgreSQL com Docker Compose:
   ```sh
   docker-compose up -d
   ```

3. Execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```

4. Acesse a documentação da API via Swagger/OpenAPI (ainda precisa ser implementado):
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## Endpoints da API

### 1. Usuários
#### Criar Usuário
**POST** `/usuarios`
```json
{
  "email": "vertinho69@gmail.com",
  "senha": "senha123",
  "role": "PROPRIETARY"
}
```

#### Buscar Usuário por ID
**GET** `/usuarios/{id}`

#### Deletar Usuário por ID
**DELETE** `/usuarios/{id}`

---

### 2. Restaurantes
#### Criar Restaurante
**POST** `/restaurantes`
```json
{
  "fotoURL": "https://www.cnnbrasil.com.br/wp-content/uploads/sites/12/2023/06/230605134133-taco-bell-vegan-crunchwrap-handout.webp",
  "nome": "Taco Bell",
  "endereco": {
    "rua": "Primeira Travessa Maria do Livramento",
    "numero": "12",
    "cidade": "Mamanguape",
    "estado": "PB",
    "cep": "01010-002"
  },
  "horarioFuncionamento": "Seg-Sex: 10h - 22h",
  "usuarioId": "5aaf4dfd-949b-47b0-a98c-5213d32cc740",
  "produtos": []
}
```

#### Buscar Restaurantes por Parâmetros
**GET** `/restaurantes/search?nome=Taco&horarioFuncionamento=10:00-22:00`

#### Editar Restaurante
**PUT** `/restaurantes/{id}`
```json
{
  "fotoURL": "https://nova-imagem.com/foto.jpg",
  "nome": "Restaurante Atualizado",
  "endereco": {
    "rua": "Rua Atualizada",
    "numero": "123",
    "cidade": "Cidade Atualizada",
    "estado": "Estado Atualizado",
    "cep": "12345-678"
  },
  "horarioFuncionamento": "10:00 - 22:00",
  "usuarioId": "5aaf4dfd-949b-47b0-a98c-5213d32cc740",
  "produtos": []
}
```

#### Buscar Restaurante por ID
**GET** `/restaurantes/{id}`

---

### 3. Produtos
#### Criar Produto
**POST** `/produtos`
```json
{
  "fotoURL": "https://meusite.com/produto.jpg",
  "nome": "Arroz de leite",
  "preco": 10.00,
  "categoria": "PF",
  "restauranteId": "41e383b7-a574-4ed1-93d2-4123a44ce0d5"
}
```

#### Buscar Produto por ID
**GET** `/produtos/{id}`

#### Deletar Produto
**DELETE** `/produtos/{id}`

---

## Autenticação
O sistema utilizará **OAuth2 com JWT** para autenticação e autorização (ainda precisa ser implementado). O acesso a alguns endpoints exigirá um token JWT válido.

## Banco de Dados
A aplicação utiliza **PostgreSQL**, com migrações gerenciadas pelo **Flyway**.

O banco de dados roda via **Docker Compose**, e pode ser iniciado com:
```sh
docker-compose up -d
```

## Documentação da API
Atualmente, a API ainda precisa ser documentada utilizando **Swagger/OpenAPI**.

## Testes
A aplicação inclui testes unitários e de integração usando **Spring Boot Test**:
```sh
mvn test
```

---

## Contato
Caso tenha dúvidas ou sugestões, entre em contato via **[GitHub](https://github.com/immark007/gommer-system-restaurant)**.


