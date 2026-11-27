# GeoPoint API

Projeto de API REST para gerenciamento de pontos geográficos,
desenvolvido com Java e Spring Boot.

## Integrantes

- Thiago Corrêa Medeiros
- Vitor Gomide

## Tecnologias utilizadas

- Java 25
- Spring Boot
- Maven
- PostgreSQL
- JDBC / JdbcTemplate

## Como executar

1. Abra o projeto no IntelliJ IDEA.
2. Crie um banco de dados chamado geo_point no PostgreSQL.
3. Execute o arquivo database.sql dentro desse banco.
4. Confira o usuário e a URL do banco no application.properties.
5. Configure a variável de ambiente DB_PASSWORD com a senha
   do seu PostgreSQL nas configurações de execução do IntelliJ.
6. Execute a classe GeopointApplication.

## URL da API

http://localhost:8080/api/points

## Endpoints

| Método | Endpoint | Operação |
| --- | --- | --- |
| POST | /api/points | Cadastrar |
| GET | /api/points | Listar |
| GET | /api/points/{id} | Consultar |
| PUT | /api/points/{id} | Atualizar |
| DELETE | /api/points/{id} | Excluir |

## Organização do projeto

- controllers: recebimento das requisições HTTP.
- services: regras de negócio e validações.
- repositories: comunicação com o banco de dados.
- entities: representação dos pontos geográficos.
- dtos: recebimento dos dados da API.
- configs: configuração e integração das camadas.

## Integração com o frontend

Mantenha a API em execução na porta 8080 e abra
o frontend utilizando o Live Server na porta 5500.