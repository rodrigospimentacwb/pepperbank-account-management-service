# account-management-service

O projeto **account-management-service** é um protótipo de microsserviços desenvolvido utilizando **Spring Boot 3** e **Kotlin**. Este projeto tem como objetivo testar e demonstrar conceitos de microsserviços, incluindo a comunicação entre serviços e o gerenciamento de estados.

## Descrição do Projeto

O **account-management-service** será responsável pelas seguintes funcionalidades:

- <span style="color: orange;">CRUD de Contas:</span> Permite criar, ler, atualizar e deletar contas.
- <span style="color: orange;">Validação de Existência de Conta:</span> Verifica a existência de uma conta com base em identificadores fornecidos.

## Pré-requisitos

Antes de executar o projeto, certifique-se de que você possui os seguintes pré-requisitos instalados:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (ou outro IDE compatível com Kotlin e Spring Boot)
- [Maven](https://maven.apache.org/index.html)
- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)

## Como Rodar

Para executar o projeto, siga os passos abaixo:

1. **Execute do docker-compose**
   
   Execute o docker-compose do projeto para que o mesmo tenha acesso aos recursos necessários.

   ```bash
   docker compose up -d
   ```

1. **Execute a migration do Liquibase**

   Execute a migration do liquibase para criação das tabelas localmente.

   ```bash
   mvn liquibase:update
   ```

3. **Configuração de execução pelo IntelliJ IDEA**

   Este projeto já possuí com arquivo de execução que o intelliJ já lê chamado ./run/StartupKt.run.xml.

Notas:

1. Este projeto utiliza no <span style="color: orange;">pom.xml</span> um plugin [No-arg compiler plugin](https://kotlinlang.org/docs/no-arg-plugin.html) evitando ter que implementar construtores vazios para funcionamento das Entidades com JPA.

   ```bash
   <plugin>jpa</plugin>
   ```
