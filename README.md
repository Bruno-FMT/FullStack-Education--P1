![logo.png](logo.png)
 <h1 align="center"> Mini Projeto 01 </h1>

**_FullStack [Education] - FMT_**

## ✒️ Desenvolvedores
- Bruno Corrêa;
- João Cypriano;
- João Victor Olivo;
- Pâmela Silva
- Rodrigo Finco Junior;

## ✏️ Descrição
Este projeto foi desenvolvido conforme as especificações passadas pelo professor para realização do primeiro
mini projeto da turma FullStack Education.

## 📌 Como usar
1. Clone este repositório: [https://github.com/Bruno-FMT/FullStack-Education--P1.git](https://github.com/Bruno-FMT/FullStack-Education--P1.git)
2. Execute a aplicação na Main que está na raiz do projeto.
3. Você pode optar por fazer as ações de um funcionário ou aluno.
4. Após esta escolha você poderá se logar, segue usuário e senhas.
   * Aluno -> usuário: johncena, senha: senha123
   * Professor -> usuário: andre, senha senha123
   * Diretor -> usuário: cesar, senha: diretor123
5. Apenas o Aluno pode realizar um novo cadastro, funcionários tem que ser cadastrados pelo diretor. 

## 🚀 Bases do projeto
### Classes
- Classes básicas:
  - Aluno
  - Professor
  - Curso
  - Turma


- Outras Classes:
  - IFuncionario
  - Funcionario
  - Diretor


- Classes de dados:
  - DadosProfessores
  - DadosDiretores
  - DadosAlunos
    <br/><br/>
---

## 🎯  Missões/Objetivos
- [x] [Ex 1 - Gitflow](#-m1s06-ex-1---gitflow)
- [x] [Ex 2 - Classes principais](#-m1s06-ex-2---classes-principais)
- [x] [Ex 3 - Encapsulamento](#-m1s06-ex-3---encapsulamento)
- [x] [Ex 4 - Interface e herança](#-m1s06-ex-4---interface-e-herança)
- [x] [Ex 5 - Enums](#-m1s06-ex-5---enums)
- [x] [Ex 6 - Override](#-m1s06-ex-6---override)
- [x] [Ex 7 - Tratamento de erros](#-m1s06-ex-7---tratamento-de-erros)
- [x] [Ex 8 - Listas de Dados](#-m1s06-ex-8---listas-de-dados)
- [x] [Ex 9 - Fluxo de Login](#-m1s06-ex-9---fluxo-de-login)
- [x] [Ex 10 - Fluxo de Ações](#-m1s06-ex-10---fluxo-de-ações)
- [x] [Alterações passadas pelo professor via Discord](#-alterações-enviadas-pelo-professor-via-discord)

## 📚 [M1S06] Ex 1 - Gitflow
Todo o sistema deve ser criado usando o gitflow: <br/>
- master → entrega final
- develop → junção de código criado pelo grupo
- feature/ → deve ter o nome da funcionalidade após o '/', dever ter um push para
  a develop a cada fim do desenvolvimento dessa funcionalidade.

## 📚 [M1S06] Ex 2 - Classes principais
Criar as classes para entidades principais: <br/>
- **Aluno** - atributos: Nome, idade
- **Professor** - atributos: Nome, idade, tempo de trabalho
- **Curso** - atributos: Nome do Curso, Professor do Curso
- **Turma** - atributos: Lista de alunos, Ano, Curso
  - métodos: listar alunos, adicionar aluno, remover aluno

## 📚 [M1S06] Ex 3 - Encapsulamento
Implemente os construtores, defina os modificadores de acesso e utilize
encapsulamento e sobrecarga de métodos.

## 📚 [M1S06] Ex 4 - Interface e Herança
- Crie a interface IFuncionario esse Funcionario deve ter os métodos: promover
- Cria a Classe Funcionário
  - Funcionário - atributos: Nome, Salario
- Crie a Classe Professor deverá herdar de Funcionário.
- Também devemos ter a classe Diretor, que irá herdar de Funcionário.
  - Diretor - atributos: Tempo de cargo

## 📚 [M1S06] Ex 5 - Enums
- Crie um enum para representar Status de Matricula e adicione ele como
  atributo a Aluno
  - Valores: ATIVO, TRANCADO, FORMADO
- Crie um enum para representar o Cargo do Funcionário. 
Adicione um campo cargo em Funcionário que receba esse Enum como tipo.
  - Valores: Iniciante, Experiente, Avançado
- Demonstrar o uso de values() e valueOf().

## 📚 [M1S06] Ex 6 - Override
Utilize o @Override e adicione um toString() personalizado a cada classe
descrita anteriormente.

## 📚 [M1S06] Ex 7 - Tratamento de erros
- Identifique diferentes tipos de erro Runtime
- Implemente tratamento de exceções com try, catch, finally.
- Utilize throws quando necessário.

## 📚 [M1S06] Ex 8 - Listas de Dados
- Crie uma classe DadosProfessores, essa classe terá uma lista de professores.
  - Metodos: adicionar professores, remover professores, buscar professores por id (id é a posição do professor)
- Crie uma classe DadosDiretores, essa classe terá uma lista de diretores.
  - Metodos: adicionar diretores, remover diretores por id, buscar diretores por id (id é a posição do diretor)
- Crie uma classe DadosAlunos, essa classe terá uma lista de alunos.
  - Metodos: adicionar alunos, remover alunos por id, buscar alunos por id (id é a posição do aluno)

## 📚 [M1S06] Ex 9 - Fluxo de login
- **Tela 1** - Ao entrar no sistema ele deve perguntar se você é funcionário ou
  aluno.
- **Tela 1** - Essa tela também deve dar a opção de Encerrar o programa.
- **Tela 2** - Ao selecionar uma opção, você deve se identificar ou criar um novo usuário.
- O usuário criado deve receber os dados necessários para criar um objeto da
  classe escolhida (professor, diretor ou aluno).
- Adicione esse usuário a lista correspondente. <br/><br/>

O aluno deve poder selecionar uma turma ao iniciar o programa. <br/>
Caso não selecione uma turma ele deve ser adicionar pelo diretor a uma turma posteriormente.

## 📚 [M1S06] Ex 10 - Fluxo de Ações
Após criação ou seleção o usuário deve ter as seguintes opções:
- aluno pode: 
  - [x] listar curso, 
  - [x] adicionar curso, 
  - [x] remover curso, 
  - [x] também pode trancar ou ativar sua conta
- o professor pode: 
  - [x] listar alunos, 
  - [x] adicionar aluno, 
  - [x] remover aluno da sua turma,
  - [x] o professor também pode mudar aluno para formado
- diretor pode: 
  - [x] realizar a promoção de um professor, 
  - [x] adicionar um professor aos DadosProfessores,
  - [x] remover um professor aos DadosProfessores,
  - [x] remover alunos aos DadosAlunos,
  - [x] adicionar alunos aos DadosAlunos, 
  - [x] diretor também pode listar todos os professores juntos dos ids,
  - [x] listar todos os alunos juntos dos ids deles,
  - [x] diretor deve poder criar uma turma
  - [x] deve poder criar um curso, 
  - [x] listar alunos da turma,
  - [x] adicionar alunos na turma,
  - [x] remover alunos da turma

- **Tela 3** - Após selecionar e executar uma ação o programa deve perguntar se o usuário
  deseja selecionar outra ação ou se deseja sair do sistema.
- Ao sair ele deve voltar as opções de login

## 📚 Alterações enviadas pelo professor via Discord
- O aluno deve poder selecionar uma turma ao iniciar o programa.
  - Caso não selecione uma turma ele deve ser adicionar pelo diretor a uma turma posteriormente.
- O diretor deve poder criar uma turma, listar alunos da turma, adicionar alunos e remover alunos da turma.
- Aluno - atributos: Nome, idade
