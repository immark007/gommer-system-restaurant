# Goomer - Sistema de Gerenciamento de Restaurantes

## 📌 Visão Geral
API completa para gerenciamento de restaurantes desenvolvida com Spring Boot MVC, PostgreSQL e Docker. A aplicação oferece endpoints para gestão de usuários, restaurantes e produtos, com recursos avançados como paginação, filtros e ordenação.

## 🚀 Tecnologias

### Principais Tecnologias
- **Java 21**
- **Spring Boot 3.4.3** (Web, Data JPA, Validation)
- **PostgreSQL 16.6** (Dockerizado)
- **Flyway** (Migrações de banco)
- **MapStruct** (Mapeamento DTO/Entity)
- **Spring HATEOAS** (Hipermídia)
- **Lombok** (Redução de boilerplate)

### Infraestrutura
- **Docker** (Containerização)
- **Docker Compose** (Orquestração)
- **PostgreSQL** (Banco de dados)

## 🛠️ Configuração do Ambiente

### Pré-requisitos
- Docker e Docker Compose instalados
- Java 21 JDK
- Maven 3.9+

### 🐳 Executando com Docker Compose
1. Crie um arquivo `.env` baseado no `.env.example`
2. Execute os containers:
```bash
docker-compose up -d
```

3. Inicie a aplicação:
```bash
mvn spring-boot:run
```

### Configuração do Banco de Dados
A aplicação está configurada para conectar-se ao PostgreSQL na porta 5440:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5440/goomer_db
spring.datasource.username=goomer
spring.datasource.password=goomer123
```

## 📚 Documentação da API

### Endpoints Base
- **API Base URL:** `http://localhost:8080/api/v1`

### 🔍 Recursos Comuns
Todos os endpoints de listagem suportam:
- Paginação: `?page=0&size=10`
- Ordenação: `?sort=nome,asc`
- Filtros específicos por entidade

### 👤 Usuários
| Método | Endpoint            | Descrição                              |
|--------|---------------------|----------------------------------------|
| POST   | `/usuarios`         | Cria um novo usuário                   |
| GET    | `/usuarios`         | Lista usuários (com filtros)           |
| GET    | `/usuarios/{id}`    | Busca usuário por ID                   |
| DELETE | `/usuarios/{id}`    | Remove um usuário                      |

**Exemplo de criação:**
```json
POST /usuarios
{
  "email": "proprietario@exemplo.com",
  "senha": "senhaSegura123",
  "role": "PROPRIETARY"
}
```

### 🏢 Restaurantes
| Método | Endpoint               | Descrição                              |
|--------|------------------------|----------------------------------------|
| POST   | `/restaurantes`        | Cria novo restaurante                  |
| GET    | `/restaurantes`        | Lista restaurantes (com filtros)       |
| GET    | `/restaurantes/{id}`   | Busca restaurante por ID               |
| PUT    | `/restaurantes/{id}`   | Atualiza restaurante                   |
| DELETE | `/restaurantes/{id}`   | Remove restaurante                     |

**Filtros disponíveis:**
- `nome`: Filtra por nome do restaurante
- `cidade`: Filtra por cidade
- `estado`: Filtra por estado
- `horario`: Filtra por horário de funcionamento

### 🍽️ Produtos
| Método | Endpoint            | Descrição                              |
|--------|---------------------|----------------------------------------|
| POST   | `/produtos`         | Cria novo produto                      |
| GET    | `/produtos`         | Lista produtos (com filtros)           |
| GET    | `/produtos/{id}`    | Busca produto por ID                   |
| PUT    | `/produtos/{id}`    | Atualiza produto                       |
| DELETE | `/produtos/{id}`    | Remove produto                         |

**Filtros disponíveis:**
- `nome`: Filtra por nome do produto
- `categoria`: Filtra por categoria (ENTRADA, PRATO_PRINCIPAL, etc.)
- `precoMin`: Preço mínimo
- `precoMax`: Preço máximo
- `restauranteId`: Filtra por restaurante

## 🔒 Segurança
- Autenticação básica implementada
- Controle de acesso por roles (PROPRIETARY, ADMIN)
- Endpoints protegidos conforme regras de negócio

## 📅 Roadmap

### ✅ Implementado
- CRUD completo para todas entidades
- Paginação e ordenação em todas listagens
- Filtros avançados com parâmetros de query
- Validação de dados
- Dockerização do ambiente
- Migrações de banco com Flyway

### 🚧 Em Desenvolvimento
- [ ] Documentação Swagger/OpenAPI
- [ ] Autenticação JWT
- [ ] Sistema de avaliações
- [ ] Upload de imagens para Cloud Storage
- [ ] Cache com Redis
- [ ] Testes de integração

## 🤝 Como Contribuir
1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📄 Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.