package testes;

import dados.DadosTurmas;
import objetos.Aluno;
import objetos.Curso;
import objetos.Turma;
import objetos.funcionarios.Professor;

import java.util.ArrayList;

public class TesteDadosTurmas {
    public static void main(String[] args) {
        System.out.println("TESTE DADOS TURMAS");
        Turma turma = new Turma(curso(), 2024);
        Turma turmaComAlunos = new Turma(curso2(), 2024, alunos());
        DadosTurmas.adicionarTurma(turma);

        System.out.println("getTurmasCadastradas deve retornar a lista de todos as turmas cadastradas");
        System.out.println(DadosTurmas.getTurmasCadastradas());

        System.out.println("\nadicionarTurma deve adicionar uma nova turma a lista de turmas cadastrados");
        DadosTurmas.adicionarTurma(turmaComAlunos);
        System.out.println(DadosTurmas.getTurmasCadastradas());

        System.out.println("\nadicionarTurma já cadastrada deve lançar exceção: Turma já cadastrada");
        try {
            DadosTurmas.adicionarTurma(turmaComAlunos);
            System.out.println(DadosTurmas.getTurmasCadastradas());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosTurmas.getTurmasCadastradas());
        }

        System.out.println("\nremoverTurma deve remover a turma passado por parâmetro");
        DadosTurmas.removerTurma(turma);
        System.out.println(DadosTurmas.getTurmasCadastradas());

        System.out.println("\nremoverTurma inexistente deve lançar exceção: Turma não encontrada");
        try {
            DadosTurmas.removerTurma(turma);
            System.out.println(DadosTurmas.getTurmasCadastradas());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosTurmas.getTurmasCadastradas());
        }

        System.out.println("\nadicionarTurmas deve adicionar um array de novas turmas a lista de turmas cadastradas");
        DadosTurmas.adicionarTurmas(arrayTurmas());
        System.out.println(DadosTurmas.getTurmasCadastradas());

        System.out.println("\nadicionarTurmas já cadastrada deve lançar exceção: Turma já cadastrada");
        try {
            DadosTurmas.adicionarTurmas(arrayTurmas());
            System.out.println(DadosTurmas.getTurmasCadastradas());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosTurmas.getTurmasCadastradas());
        }

        System.out.println("**** TESTE DADOS TURMAS CONCLUÍDO COM SUCESSO! ****");
    }

    public static Curso curso(){
        return new Curso("FullStack", professores());
    }
    public static Curso curso2(){
        return new Curso("Front-end", professores());
    }

    public static ArrayList<Professor> professores() {
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(new Professor("João Silva", 40, 3000.50, 3));
        professores.add(new Professor("Maria Oliveira", 50, 3000.00, 3));

        return professores;
    }

    public static ArrayList<Aluno> alunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("André Almeida", 16));
        alunos.add(new Aluno("Sofia Rodrigues", 17));
        alunos.add(new Aluno("Carolina Gonçalves", 21));

        return alunos;
    }

    public static ArrayList<Turma> arrayTurmas() {
        ArrayList<Turma> turmas = new ArrayList<>();
        Curso html = new Curso("HTML", professores());
        Curso ts = new Curso("TS", professores());
        Curso sql = new Curso("SQL", professores());
        turmas.add(new Turma(html, 2024));
        turmas.add(new Turma(ts, 2024));
        turmas.add(new Turma(sql, 2024));

        return turmas;
    }
}
