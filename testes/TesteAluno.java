package testes;

import dados.DadosAlunos;
import objetos.Aluno;

public class TesteAluno {
    public static void main(String[] args) {
        System.out.println("TESTES ALUNO");
        System.out.println("Aluno deve receber um nome em String e uma idade entre 0 e 120");
        Aluno aluno = new Aluno("Jane Doe", 40);
        DadosAlunos.adicionarAluno(aluno);
        System.out.println(aluno);

        System.out.println("\nNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            Aluno alunoErroNome = new Aluno("", 40);
            System.out.println(alunoErroNome);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\nIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            Aluno alunoErroIdade = new Aluno("Jane Doe", 150);
            System.out.println(alunoErroIdade);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\ngetNome deve retornar uma String com o nome do aluno");
        System.out.println(aluno.getNome());

        System.out.println("\nsetNome deve incluir um novo nome ao aluno");
        aluno.setNome("Jhon Doe");
        System.out.println(aluno.getNome());

        System.out.println("\nsetNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            aluno.setNome("");
            System.out.println(aluno.getNome());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getNome());
        }

        System.out.println("\ngetIdade deve retornar um int com a idade do aluno");
        System.out.println(aluno.getIdade());

        System.out.println("\nsetIdade deve incluir uma nova idade ao aluno");
        aluno.setIdade(41);
        System.out.println(aluno.getIdade());

        System.out.println("\nsetIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            aluno.setIdade(130);
            System.out.println(aluno.getIdade());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getIdade());
        }

        System.out.println("\ngetId deve retornar um int com o id de Aluno (que será a posição dele em dadosAlunos)");
        System.out.println(aluno.getId());

        System.out.println("\ngetId deve retornar -1 caso o aluno em esteja em dadosAlunos");
        DadosAlunos.removerAlunoPorId(0);
        System.out.println(aluno.getId());

        System.out.println("\ngetStatusMatricula deve retornar o status da matrícula do aluno");
        System.out.println(aluno.getStatusMatricula());

        System.out.println("\nsetStatusMatricula incluir novo o status da matrícula do aluno passado por String");
        aluno.setStatusMatricula("TRANCADO");
        System.out.println(aluno.getStatusMatricula());

        System.out.println("\nsetStatusMatricula ao receber status invalido deve lançar exceção: Status de matrícula invalido.");
        try {
            aluno.setStatusMatricula("TRANCADA");
            System.out.println(aluno.getStatusMatricula());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getStatusMatricula());
        }

        System.out.println("\ntoString deve trazer nome e idade do aluno");
        System.out.println(aluno.toString());

        System.out.println("\nimprimirOpcoesStatusMatricula deve mostrar no console todas as opções de status de matrícula");
        aluno.imprimirOpcoesStatusMatricula();
    }
}
