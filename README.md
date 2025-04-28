# Equipeum - Sistema de Gestão de Equipamentos da Empresa

## 🟢1. Visão Geral

Nosso Projeto é um **Sistema de Gestão de Equipamentos da Empresa** que permite:

- Cadastro de equipamentos da empresa;
- Cadastro de funcionarios;
- Empréstimos de equipamentos para funcionarios bem como data de retirada, responsável e status;
- Devolução de equipamentos;
- Processo de desligamento do funcionário bem como listagem de todos os equipamentos cadastrados e que precisam ser devolvidos antes do desligamento ocorrer.

## 🟢2. Objetivo

- Desenvolver um sistema funcional que permita gerenciar todo o ciclo de vida dos equipamentos da empresa;

## 🟢4. Principais Funcionalidades

- Cadastro e listagem de funcionários;
- Cadastro e listagem de equipamentos;
- Registro de Empréstimo e devolução de equipamentos;
- Visualização do histórico de movimentação por equipamento e por funcionário;
- Solicitação e consulta de status de desligamento de um funcionário;
- Consulta de funcionários com pendências de devolução de equipamento para desligamento.

## 🟢5. Arquitetura do Projeto

- **Padrão MVC** (Model, View, Controller)
- Separação por pacotes: Controller, DTO, Entity, Mapper, Repository, Service;
- Banco de dados não relacional (MongoDB);
- Visualização FrontEnd HTML via IntelliJ.

## 🟢6. Tecnologias Utilizadas

- IDE: IntelliJ
- Banco de Dados: MongoDB
- Framework: Spring Boot
- Gerenciamento de API: Postman
- Gerenciador de dependências: Maven

- Dependências:

    - Spring WEB
    - MongoDB
    - Validation

## 🟢7. Telas do Sistema

- Tela de cadastro;
- Menu Principal;
- Lista de Equipamentos;
- Lista de Funcionários;
- Registro de empréstimos;
- Histórico de movimentação
- Devolução;
- Tela de pendências.

## 🟢8. Fluxo de Funcionamento

1. Requisição
O usuário envia uma requisição HTTP (ex: cadastro de funcionário, empréstimo de equipamento) via Postman ou interface web.

2. Controller
A controller recebe a requisição, valida os dados com um DTO e chama o serviço correspondente.

3. Service
A service executa a lógica de negócio, como:

Verificar disponibilidade de equipamento;

Registrar empréstimo/devolução;

Validar pendências antes do desligamento.

4. Repository
As entidades são salvas ou consultadas no MongoDB via Spring Data (FuncionarioRepository, EquipamentoRepository, etc.).

5. Resposta
A controller retorna um ResponseEntity com o status da operação (200, 201, 400, etc.).

### Exemplos de Fluxo
Cadastro de Funcionário
POST /funcionarios/cadastro → Valida DTO → Salva no MongoDB

Empréstimo de Equipamento
POST /equipamentos/emprestimo → Verifica disponibilidade → Atualiza status

Devolução
POST /equipamentos/devolucao → Marca como disponível → Persiste no banco

Desligamento de Funcionário
POST /funcionarios/desligamento → Verifica pendências → Bloqueia ou permite
