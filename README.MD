# account-management-service

O projeto **account-management-service** é um protótipo de microsserviços desenvolvido utilizando **Spring Boot 3** e **Kotlin**. Este projeto tem como objetivo testar e demonstrar conceitos de microsserviços, incluindo a comunicação entre serviços e o gerenciamento de estados.

## Descrição do Projeto

O **account-management-service** será responsável pelas seguintes funcionalidades:

- **CRUD de Contas:** Permite criar, ler, atualizar e deletar contas.
- **Validação de Existência de Conta:** Verifica a existência de uma conta com base em identificadores fornecidos.

## Pré-requisitos

Antes de executar o projeto, certifique-se de que você possui os seguintes pré-requisitos instalados:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (ou outro IDE compatível com Kotlin e Spring Boot)

## Como Rodar

Para executar o projeto, siga os passos abaixo:

1. **Configurar Variáveis de Ambiente**

   Antes de iniciar o projeto, você precisa configurar as variáveis de ambiente. Execute o script `setDevEnvVars.sh`[setDevEnvVars](setDevEnvVars) para carregar as variáveis do arquivo `.env`:

   ```bash
   $ chmod +x setDevEnvVars
   $ source ./setDevEnvVars.sh
   ```
   
   **Nota: Este arquivo .env não esta versionado.** 

**Exemplo do .env**
   ```bash
   # .env
   DB_PASSWORD=SENHA
   DB_USERNAME=NOME
   DB_URL=jdbc:postgresql://localhost:5432/postgre
   DB_NAME=nomeDoDataBase
   ```

2. **Execute do docker-compose**
   
   Execute o docker-compose do projeto para que o mesmo tenha acesso aos recursos necessários.

   ```bash
   docker compose up -d
   ```

3. **Configuração de execução pelo IntelliJ IDEA**

   Este projeto já possuí com arquivo de execução que o intelliJ já lê chamado ./run/StartupKt.run.xml. Este também busca pelo arquivo .env na raíz do projeto.