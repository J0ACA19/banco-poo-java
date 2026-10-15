# Banco em Java

Sistema bancário simples em Java, com menu no console, feito para praticar **programação orientada a objetos**: classes, objetos, construtores, encapsulamento e composição.

## Funcionalidades

- Criar conta (o número é gerado automaticamente, a partir de 1001)
- Depositar
- Sacar
- Transferir entre contas
- Consultar saldo
- Listar contas

## Estrutura do projeto

```
src/
└── ContaBancaria/
    ├── Conta.java      # nome, número e saldo; depósito e saque
    ├── Banco.java      # guarda as contas; criar, buscar, transferir e listar
    └── Principal.java  # main com o menu
```

| Classe | Responsabilidade |
|---|---|
| `Conta` | Representa uma conta. Atributos privados, com validação de valor no depósito e no saque. |
| `Banco` | Guarda as contas em um vetor que cresce a cada conta criada (sem `ArrayList`). |
| `Principal` | Lê a entrada do usuário e chama os métodos do `Banco` e da `Conta`. |

## Como executar

Pré-requisito: **JDK 8 ou superior** instalado.

Pelo terminal, na pasta raiz do projeto:

```bash
javac -d out src/ContaBancaria/*.java
java -cp out ContaBancaria.Principal
```

Também é possível importar o projeto no Eclipse ou no IntelliJ e executar a classe `Principal`.

## Exemplo de uso

```
===== BANCO =====

1 - Criar conta
2 - Depositar
3 - Sacar
4 - Transferir
5 - Consultar saldo
6 - Listar contas
7 - Encerrar
Insira sua opção: 1
Insira o nome: Joaquim
Conta criada! Número da conta: 1001
Insira sua opção: 1
Insira o nome: Maria
Conta criada! Número da conta: 1002
Insira sua opção: 2
Número da conta: 1001
Valor do depósito: 500
Depósito realizado. Saldo: 500.0
Insira sua opção: 3
Número da conta: 1001
Valor do saque: 200
Saque realizado. Saldo: 300.0
Insira sua opção: 4
Número da conta de origem: 1001
Número da conta de destino: 1002
Valor da transferência: 100
Transferência realizada.
Saldo da conta de origem: 200.0
Saldo da conta de destino: 100.0
Insira sua opção: 5
Número da conta: 1002
Saldo da conta 1002: 100.0
Insira sua opção: 6
Lista de contas
1001 - Joaquim - Saldo: 200.0
1002 - Maria - Saldo: 100.0
Insira sua opção: 7
Fechando o banco
```

## Regras de negócio

- Depósito e saque só aceitam valores **maiores que zero**.
- O saque só ocorre se houver **saldo suficiente**.
- A transferência só ocorre se as duas contas existirem, forem **diferentes** e a origem tiver saldo suficiente.
- Contas são identificadas pelo **número**, e dois titulares podem ter o mesmo nome.

## Conceitos praticados

- Classes, atributos e métodos
- Construtores e `this`
- Encapsulamento (`private`, getters)
- Vetor de objetos com crescimento manual
- Menu com `do-while` e `switch`
- Leitura de dados com `Scanner`

## Possíveis melhorias

- Extrato de movimentações por conta
- Validação de CPF do titular
- Formatação dos valores com duas casas decimais
- Guardar valores em centavos (`long`) em vez de `double`
