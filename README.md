![logo.png](logo.png)
 <h1 align="center"> Mini Projeto 01 </h1>

**FullStack [Education] - FMT**

## ✒️ Desenvolvedores
- Bruno Corrêa;
- João Cypriano;
- João Victor Olivo;
- Pâmela Silva
- Rodrigo Finco Junior;

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
- [ ] [Ex 4 - Interface e herança](#-m1s06-ex-4---interface-e-herança)
- [x] [Ex 5 - Enums](#-m1s06-ex-5---enums)
- [ ] [Ex 6 - Override](#-m1s06-ex-6---override)
- [ ] [Ex 7 - Tratamento de erros](#-m1s06-ex-7---tratamento-de-erros)
- [ ] [Ex 8 - Listas de Dados](#-m1s06-ex-8---listas-de-dados)
- [ ] [Ex 9 - Fluxo de Login](#-m1s06-ex-9---fluxo-de-login)
- [ ] [Ex 10 - Fluxo de Ações](#-m1s06-ex-10---fluxo-de-ações)
- [ ] [Alterações passadas pelo professor via Discord](#-alterações-enviadas-pelo-professor-via-discord)

## 📚 [M1S06] Ex 1 - Gitflow
Todo o sistema deve ser criado usando o gitflow: <br/>
- master → entrega final
- develop → junção de código criado pelo grupo
- feature/ → deve ter o nome da funcionalidade após o '/', dever ter um push para
  a develop a cada fim do desenvolvimento dessa funcionalidade.

## 📚 [M1S06] Ex 2 - Classes principais
Criar as classes para entidades principais: <br/>
- **Aluno** - atributos: Nome, Lista de cursos
  - métodos: listar curso, adicionar curso, remover curso
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
- **Tela 2** - Ao selecionar uma opção, você deve se identificar ou criar um novo usuário.
- **Tela 2** - Essa tela também deve dar a opção de Encerrar o programa.
- O usuário criado deve receber os dados necessários para criar um objeto da
  classe escolhida (professor, diretor ou aluno).
- Adicione esse usuário a lista correspondente.

## 📚 [M1S06] Ex 10 - Fluxo de Ações
Após criação ou seleção o usuário deve ter as seguinte opções:
- aluno pode: listar curso, adicionar curso, remover curso,
  também pode trancar ou ativar sua conta
- o professor pode: listar alunos, adicionar aluno, remover aluno da sua turma
- diretor pode: realizar a promoção de um professor, pode adicionar ou remover
  um professor aos DadosProfessores e pode remover ou adicionar alunos aos DadosAlunos
  - o diretor também pode listar todos os professores e todos os alunos, juntos dos ids deles

- **Tela 3** - Após selecionar e executar uma ação o programa deve perguntar se o usuário
  deseja selecionar outra ação ou se deseja sair do sistema.
- Ao sair ele deve voltar as opções de login

## 📚 Alterações enviadas pelo professor via Discord
- O aluno deve poder selecionar uma turma ao iniciar o programa.
  - Caso não selecione uma turma ele deve ser adicionar pelo diretor a uma turma posteriormente.
- O diretor deve poder criar uma turma, listar alunos da turma, adicionar alunos e remover alunos da turma.
- Aluno - atributos: Nome, idade