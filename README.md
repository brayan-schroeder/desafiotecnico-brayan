# Desafio Técnico - Brayan (Outsera)

## Requisitos

- Java 17
- Maven

## Como rodar o projeto

- Clonar o repositório
- Executar 'mvn spring-boot:run' para iniciar a aplicação
- A API estará disponível em: GET http://localhost:8080/filmes/intervalo_premios

## Como rodar os testes

- Executar 'mvn test'

## Endpoints

GET http://localhost:8080/filmes/intervalo_premios

## Especificação

1. Ler o CSV dos filmes e inserir os dados em um base H2 ao iniciar a aplicação ✅
2. Obter o produtor com maior intervalo entre 2 prêmios consecutivos, e o que obteve 2 prêmios mais rápido ✅
3. Respeitar o nível 2 de maturidade de Richardson ✅
4. Implementar somente teste de integração ✅
