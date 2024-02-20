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
        professores.add(professor1);
        professores.add(professor2);
        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        arrayTurmas.add(turma1);
        arrayTurmas.add(turma2);
        arrayTurmas.add(turma3);
        Turma turma = new Turma(curso, 2024, alunos);

        System.out.println("getTurmasCadastradas deve retornar a lista de todos as turmas cadastradas");
        System.out.println(DadosTurmas.getTurmasCadastradas());

        System.out.println("\nadicionarTurma deve adicionar uma nova turma a lista de turmas cadastrados, isso ocorre quando a turma é cadastrada");
        Turma turmaComAlunos = new Turma(curso2, 2024, alunos);
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
        DadosTurmas.adicionarTurmas(arrayTurmas);
        System.out.println(DadosTurmas.getTurmasCadastradas());

        System.out.println("\nadicionarTurmas já cadastrada deve lançar exceção: Turma já cadastrada");
        try {
            DadosTurmas.adicionarTurmas(arrayTurmas);
            System.out.println(DadosTurmas.getTurmasCadastradas());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosTurmas.getTurmasCadastradas());
        }

        System.out.println("**** TESTE DADOS TURMAS CONCLUÍDO COM SUCESSO! ****");
    }

    public static Professor professor1 = new Professor("João Silva", 40, 3000.50, 3, "joaosilva", "senha1234");
    public static Professor professor2 = new Professor("Maria Oliveira", 50, 3000.00, 3, "mariaoliveira", "senha1234");
    public static ArrayList<Professor> professores = new ArrayList<>();

    public static Curso curso = new Curso("FullStack", professores);
    public static Curso curso2 = new Curso("Front-end", professores);

    public static ArrayList<Aluno> alunos = new ArrayList<>();
    public static Aluno aluno1 = new Aluno("André Almeida", 16, "andrealmeida", "senha1234");
    public static Aluno aluno2 = new Aluno("Sofia Rodrigues", 17, "sofia", "senha1234");
    public static Aluno aluno3 = new Aluno("Carolina Gonçalves", 21, "carolinagoncalves", "senha1234");

    public static Curso html = new Curso("HTML", professores);
    public static Curso ts = new Curso("TS", professores);
    public static Curso sql = new Curso("SQL", professores);
    public static Turma turma1 = new Turma(html, 2024);
    public static Turma turma2 = new Turma(ts, 2024);
    public static Turma turma3 = new Turma(sql, 2024);

    public static ArrayList<Turma> arrayTurmas = new ArrayList<>();
}
