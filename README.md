<p align="center">
  <img src="https://img.shields.io/badge/Java-25-red?logo=java" alt="Java"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/JPA-Hibernate-blue" alt="JPA"/>
  <img src="https://img.shields.io/badge/Oracle-21c-orange?logo=oracle" alt="Oracle"/>
</p>

<h1 align="center">Checkpoint 5 - CRM com Persistência em Banco de Dados</h1>

<p align="center">
Disciplina: <b>Domain-Driven Design with Java</b><br>
Professor: <b>Carlos Eduardo Machado de Oliveira</b>
</p>

---

## 📌 Descrição da Atividade

Este projeto corresponde ao **Checkpoint 5**, cujo objetivo é conectar o domínio desenvolvido no Checkpoint 4 com um banco de dados relacional, aplicando conceitos de **Domain-Driven Design (DDD)**.

A aplicação implementa persistência utilizando **Spring Data JPA**, garantindo operações completas de CRUD para todas as entidades do sistema.

---

## 🎯 Objetivo

Aplicar conceitos iniciais de DDD integrando:

- Camada de domínio
- Camada de aplicação (services)
- Persistência com banco de dados (Oracle 21c)

---

## Equipe **EPDM**

| Nome               | RM     |
|--------------------|--------|
| Kayque Carvalho    | 561189 |
| Erik Suguiyama     | 559273 |
| Lucas Guerreiro    | 560359 |
| Guilherme Vital    | 560073 |
| Belton Carr        | 560760 |

---

## 📋 Requisitos Atendidos

✔ Cadastro de todas as entidades  
✔ Listagem de registros  
✔ Atualização de dados  
✔ Exclusão de registros  
✔ Integração com banco de dados via JPA  
✔ Cada entidade com sua própria tabela  

---

## Domínio do Sistema

O sistema CRM gerencia o ciclo completo de relacionamento com clientes:

- Captação de leads (Prospectantes)
- Conversão em Clientes
- Gestão de equipes (Vendedores e Atendentes)
- Administração de Usuários e Contratos

---


## 🏗️ Estrutura do Projeto (DDD)

```Bash
src/main/java/br/com/fiap2espa/cp4/

│  
├── controller/  
│   ├── AtendenteController.java  
│   ├── ClienteController.java  
│   ├── ProspectanteController.java  
│   ├── VendedorController.java  
│   ├── UsuarioController.java  
│   └── ContratoController.java  
│  
├── service/  
│   ├── AtendenteService.java  
│   ├── ClienteService.java  
│   ├── ProspectanteService.java  
│   ├── VendedorService.java  
│   ├── UsuarioService.java  
│   └── ContratoService.java  
│  
├── dto/  
│   ├── RequestDTOs  
│   └── ResponseDTOs  
│  
└── domain/  
    ├── model/
    ├── enums/  
    ├── vo/  
    └── repository/  

```

---

## 🧩 Modelo de Domínio

### Entidades

- Vendedor
- Atendente
- Prospectante
- Cliente
- Usuario
- Contrato

### Value Object

- Endereco (imutável)

### Enumerações

- Qualificacao
- Tipo
- AreaDeInteresse
- Status

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia        | Descrição |
|------------------|----------|
| Java 25          | Linguagem principal |
| Spring Boot      | Framework backend |
| Spring Data JPA  | Persistência |
| Hibernate        | ORM |
| Oracle 21c       | Banco de dados |
| Lombok           | Redução de código |
| Maven            | Build |

---

## ⚙️ Configuração do Banco

```
spring:
  datasource:
    url: jdbc:oracle:thin:@//localhost:1521/XEPDB1
    username: SEU_USUARIO
    password: SUA_SENHA
    driver-class-name: oracle.jdbc.OracleDriver
  jpa:
    database-platform: org.hibernate.dialect.OracleDialect
    hibernate:
      # 'update' cria as tabelas automaticamente (tb_cliente, tb_vendedor, etc)
      # se elas não existirem no banco.
      ddl-auto: update
    show-sql: true # mostra os comandos SQL no console para debug
    properties:
      hibernate:
        format_sql: true

```
---

## 📡 Endpoints

A API disponibiliza endpoints REST para todas as entidades:

- /clientes
- /usuarios
- /contratos
- /vendedores
- /atendentes
- /prospectos

Todos com operações:

GET | POST | PUT | DELETE

Clientes:
GET /clientes  
GET /clientes/{id}  
POST /clientes  
PUT /clientes/{id}  
DELETE /clientes/{id}  

Usuarios:
GET /usuarios  
GET /usuarios/{id}  
POST /usuarios  
PUT /usuarios/{id}  
DELETE /usuarios/{id}  

Contratos:
GET /contratos  
GET /contratos/{id}  
POST /contratos  
PUT /contratos/{id}  
DELETE /contratos/{id}  

---

## 🧪 Exemplo de Requisição

POST /clientes

```
{
  "nome": "João Silva",
  "cpf": "12345678900",
  "email": "joao@email.com",
  "telefone": "11999999999",
  "endereco": {
    "rua": "Rua A",
    "numero": "123",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "01000-000"
  }
}
```

---

## ⚠️ Exemplo Tratamento de Erros

```
{
  "status": 404,
  "message": "Cliente não encontrado"
}
```
---
