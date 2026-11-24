# Estoque-API

API REST para controlar o estoque de uma loja. Permite cadastrar, consultar, atualizar, listar e remover produtos, com os dados guardados em PostgreSQL.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Docker


## Como rodar

1. Abra o Docker Desktop e espere aparecer *Engine running*.
2. Copie o arquivo `.env.example` para `.env` na raiz do projeto e preencha as variáveis `DB_NAME`, `DB_USER` e `DB_PASSWORD`.
3. No terminal, na pasta do projeto, rode: `docker compose up -d`
4. No IntelliJ, vá em **Run → Edit Configurations** e aponte o arquivo `.env` no campo "Environment variables".
5. Rode a aplicação com o botão **Run**.
6. A API fica em: http://localhost:8081/produtos

## Endpoints

| Método | URL                  | O que faz                                             |
|--------|----------------------|-------------------------------------------------------|
| POST   | /produtos            | Cadastra um produto (se já existe, soma a quantidade) |
| GET    | /produtos/{nome} | Busca o produto cadastrado                            |
| GET    | /produtos            | Checa a lista de produtos cadastrados                 |
| PUT    | /produtos            | Substitui a quantidade do produto cadastrado           |
| DELETE | /produtos/{nome}     | Deleta o produto cadastrado                           |
