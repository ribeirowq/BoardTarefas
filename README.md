# BoardTarefas

Este projeto, desenvolvido como parte do **Desafio do Bootcamp Santander Java 2025, orquestrado pela DIO (Digital Innovation One)**, é uma aplicação de gerenciamento de tarefas em formato de quadro (Board).

## Visão Geral

O `BoardTarefas` é uma aplicação Java que simula um sistema de gerenciamento de tarefas, permitindo a organização de atividades em diferentes colunas (como 'A Fazer', 'Em Andamento', 'Concluído'). Ele demonstra a aplicação de conceitos de persistência de dados, lógica de negócios e interação com o usuário em um ambiente Java.

## Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias e ferramentas:

- **Linguagem**: Java 17
- **Gerenciador de Dependências**: Gradle (com Kotlin DSL)
- **Banco de Dados**: MySQL
- **Framework de Persistência**: JDBC (Java Database Connectivity)
- **Migração de Banco de Dados**: Liquibase
- **Ferramentas de Desenvolvimento**: Lombok (para redução de boilerplate)

## Estrutura do Projeto

A arquitetura do projeto segue um padrão em camadas, promovendo a separação de responsabilidades:

```
src/
├── main/
│   ├── java/
│   │   └── application/
│   │       ├── dto/             # Data Transfer Objects
│   │       ├── exception/       # Classes de exceção
│   │       ├── persistence/     # Camada de persistência de dados
│   │       │   ├── config/      # Configuração de conexão com o DB
│   │       │   ├── converter/   # Conversores de dados
│   │       │   ├── dao/         # Data Access Objects (interação com o DB)
│   │       │   ├── entity/      # Entidades de domínio (representação do DB)
│   │       │   └── migration/   # Estratégias de migração do DB (Liquibase)
│   │       ├── service/         # Lógica de negócios da aplicação
│   │       └── ui/              # Classes de interface do usuário (menus)
│   └── resources/
└── test/
    └── java/
        └── application/
            └── persistence/
                └── config/
                    └── ConnectionConfigTest.java
```

### Detalhes da Arquitetura:

- **`application.Main`**: Ponto de entrada da aplicação, responsável por iniciar as migrações do banco de dados e o menu principal.
- **`persistence.config`**: Contém `ConnectionConfig.java` para gerenciar a conexão com o banco de dados MySQL.
- **`persistence.dto`**: Define os objetos de transferência de dados (`BoardColumnDTO`, `BoardDetailsDTO`, `CardDetailsDTO`, etc.) para comunicação entre as camadas.
- **`persistence.dao`**: Implementa as operações CRUD (Create, Read, Update, Delete) para as entidades do sistema (`BlockDAO`, `BoardColumnDAO`, `BoardDAO`, `CardDAO`).
- **`persistence.entity`**: Representa as estruturas de dados do banco de dados como objetos Java (`BlockEntity`, `BoardColumnEntity`, `BoardEntity`, `CardEntity`).
- **`persistence.migration`**: Utiliza Liquibase para gerenciar o esquema do banco de dados, garantindo que as tabelas e dados iniciais estejam corretos.
- **`service`**: Contém a lógica de negócios, orquestrando as operações dos DAOs e aplicando regras de negócio (`BoardService`, `CardService`, etc.).
- **`ui`**: Responsável pela interação com o usuário através de menus de console (`MainMenu`, `BoardMenu`).

## Como Executar

Para executar este projeto localmente, siga os passos abaixo:

1.  **Pré-requisitos:**
    *   Java Development Kit (JDK) 17 ou superior
    *   MySQL Server instalado e em execução
    *   Gradle (geralmente incluído no projeto via `gradlew`)

2.  **Configuração do Banco de Dados:**
    *   Crie um banco de dados MySQL chamado `board`.
    *   As credenciais de acesso padrão são `user: board` e `password: board`. Se desejar alterá-las, edite o arquivo `src/main/java/application/persistence/config/ConnectionConfig.java`.

3.  **Clonar o Repositório:**
    ```bash
    git clone https://github.com/ribeirowq/BoardTarefas.git
    cd BoardTarefas
    ```

4.  **Executar a Aplicação:**
    *   Utilize o Gradle Wrapper para executar a aplicação. As migrações do banco de dados serão aplicadas automaticamente no primeiro uso.
    ```bash
    ./gradlew run
    ```
    *   No Windows, use `gradlew.bat run`.

    A aplicação será iniciada no console, apresentando o menu principal.

## Funcionalidades

Embora a interação seja via console, a estrutura do projeto suporta as seguintes funcionalidades para um sistema de gerenciamento de tarefas:

- Criação e gerenciamento de quadros de tarefas.
- Criação e gerenciamento de colunas dentro dos quadros.
- Criação e gerenciamento de cartões (tarefas) dentro das colunas.
- Persistência de todos os dados em um banco de dados MySQL.
