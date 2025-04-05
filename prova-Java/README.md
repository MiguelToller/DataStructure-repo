# Prova de Estrutura de dados  

Este projeto contém a resolução de uma prova prática com foco em manipulação de objetos, controle de duplicidade e uso de estruturas de dados em **Java**.

---

## Parte 1 - Classe `Turma` e Controle de Duplicidade

Foi implementada a classe `Turma` com os seguintes atributos:

- `nome` (String)  
- `cpf` (String) – utilizado como identificador único (chave primária)  
- `dataNascimento` (String ou Date)

### Requisitos:

- O método `equals()` foi reescrito para utilizar o atributo `cpf` como chave de comparação.

---

## Parte 2 - Cadastro de Equipes de Futebol

Foi desenvolvido um programa com as seguintes funcionalidades:

1. Permitir o preenchimento de N nomes de equipes de futebol, obrigatoriamente em letras maiúsculas.
2. Armazenar os nomes em uma estrutura com controle de duplicidade (como dicionário, mapa ou conjunto).
3. Exibir:
   - Os nomes das equipes cadastradas.
   - A quantidade total de equipes cadastradas.

---

## Parte 3 - Manipulação de Objetos da Classe `Cidade`

Foi implementada a classe `Cidade` com os seguintes atributos:

- `nomeCidade` (String) – nome completo da cidade em letras maiúsculas
- `siglaCidade` (String) – sigla da cidade em letras maiúsculas

O controle de duplicidade é feito com base no nome da cidade.

### Funcionalidades do Programa:

Menu interativo com as seguintes opções:

1. **Cadastrar cidade**  
   - Entrada do nome da cidade e sigla da cidade (ambos em maiúsculo).  
   - Adição à lista de cidades, com controle de duplicidade.

2. **Listar cidades cadastradas**  
   - Apresenta todas as cidades cadastradas, ordenadas pelo nome.

3. **Pesquisar cidade por nome**  
   - Busca uma cidade pelo nome e exibe a sigla da cidade correspondente.

4. **Remover cidade por nome**  
   - Remove uma cidade da lista a partir do nome informado.

5. **Finalizar programa**
