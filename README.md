# FIAP - Checkpoint 4: Gestão de Relacionamento (CRM)

**Disciplina**: DDD Java

**Turma:** 2ESPA

**Integrantes:**
* Kayque Carvalho - RM: 561189
* Erik Suguiyama - RM: 559273
* Lucas Guerreiro - RM: 560359
* Guilherme Vital - RM: 560073
* Belton Carr - RM: 560760

---

## 1. Objetivo do Projeto
   Este projeto consiste no desenvolvimento de um sistema de gestão de relacionamento com o cliente (CRM) focado na organização de uma Estrutura de pacotes
   eficiente e escalável. O sistema gerencia o ciclo de vida de interessados (Prospectantes) até a conversão em clientes efetivos, além de organizar as equipes de vendas e atendimento.

## 2. Tecnologias Utilizadas
   Java 17: Linguagem base para o desenvolvimento.
   Spring Boot: Framework para criação da API REST e injeção de dependência.
   Spring Data JPA: Para persistência de dados e comunicação com o banco.
   Lombok: Para redução de código boilerplate (Getters, Setters e Construtores).
   MySQL: Banco de dados relacional para armazenamento persistente.


## 3. Estrutura de pacotes

```
src/main/java/br/com/fiap2espa/
│
├── controller/          # Porta de entrada (API)
├── service/             # Regras de negócio e fluxos
├── dto/                 # Objetos de transferência (JSON)
└── domain/              # O Domínio do seu sistema
    ├── model/           # ENTIDADES (@Entity)
    ├── enums/           # Enumerações
    ├── vo/              # Value Objects (@Embeddable)
    └── repository/      # Comunicação com o Banco (JPA)
```

## Next Steps

Conexão com Banco de dados MySQL

1. MySQL: Banco de dados relacional para armazenamento persistente.
2. Configuração das credências do banco de dados em ```src/main/resources/application.properties```
3. Adição das dependências do driver MySQL em ```pom.xml```
