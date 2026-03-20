# CP 4

Estrutura de pacotes

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