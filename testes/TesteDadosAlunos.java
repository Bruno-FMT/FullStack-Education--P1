package testes;

import dados.DadosAlunos;
import objetos.Aluno;

import java.util.ArrayList;

public class TesteDadosAlunos {
    public static void main(String[] args) {
        System.out.println("TESTE DADOS ALUNOS");
        Aluno aluno = new Aluno("Jane Doe", 40, "janedoe", "senha1234");

        System.out.println("getAlunosCadastrados deve retornar a lista de todos os alunos cadastrados");
        System.out.println(DadosAlunos.getAlunosCadastrados());

        System.out.println("\nadicionarAluno deve adicionar um novo aluno a lista de alunos cadastrados, isso ocorre quando criamos um novo usuário");
        Aluno aluno2 = new Aluno("Jhon Doe", 50, "jhonDoe", "senha1234");
        System.out.println(DadosAlunos.getAlunosCadastrados());

        System.out.println("\nadicionarAluno já cadastrado deve lançar exceção: Aluno já cadastrado");
        try {
            DadosAlunos.adicionarAluno(aluno2);
            System.out.println(DadosAlunos.getAlunosCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosAlunos.getAlunosCadastrados());
        }

        System.out.println("\nremoverAlunoPorId deve remover da lista de alunos cadastrados o aluno na posição informada");
        DadosAlunos.removerAlunoPorId(0);
        System.out.println(DadosAlunos.getAlunosCadastrados());

        System.out.println("\nremoverAlunoPorId posição inexistente deve lançar exceção: Nenhum aluno encontrado com o id informado.");
        try {
            DadosAlunos.removerAlunoPorId(30);
            System.out.println(DadosAlunos.getAlunosCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosAlunos.getAlunosCadastrados());
        }

        System.out.println("\ngetAlunoPorId trará as informações do aluno na posição informada");
        System.out.println(DadosAlunos.getAlunoPorId(0));

        System.out.println("\ngetAlunoPorId posição inexistente deve lançar exceção: Nenhum aluno encontrado com o id informado.");
        try {
            DadosAlunos.getAlunoPorId(30);
            System.out.println(DadosAlunos.getAlunosCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosAlunos.getAlunosCadastrados());
        }

        System.out.println("**** TESTE DADOS ALUNOS CONCLUÍDO COM SUCESSO! ****");
    }
}
