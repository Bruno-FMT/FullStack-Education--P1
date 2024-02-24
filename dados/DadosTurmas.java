package dados;

import objetos.Aluno;
import objetos.Curso;
import objetos.Turma;

import java.util.ArrayList;
import java.util.List;

public class DadosTurmas {
    private static List<Turma> turmasCadastradas = new ArrayList<>();

    public static List<Turma> getTurmasCadastradas() {
        return turmasCadastradas;
    }

    public static List<Turma> getTurmasPorAluno(Aluno aluno) {
        List<Turma> turmas = new ArrayList<>();
        for (Turma turma : turmas) {
            if (turma.getAlunos().contains(aluno)) {
                turmas.add(turma);
            }
        }
        return turmas;
    }

    public static List<Turma> getTurmasPorCurso(Curso curso) {
        List<Turma> turmas = new ArrayList<>();
        for (Turma turma : turmasCadastradas) {
            if (turma.getCurso().equals(curso)) {
                turmas.add(turma);
            }
        }
        return turmas;
    }

    public static void removerTurma(Turma turma) {
        if (!turmaEhCadastrada(turma)) {
            throw new IllegalArgumentException("Turma não encontrada.");
        }
        turmasCadastradas.remove(turma);
    }

    public static void adicionarTurma(Turma turma) {
        if (turmaEhCadastrada(turma)) {
            throw new IllegalArgumentException("Turma já cadastrada.");
        }
        turmasCadastradas.add(turma);
    }

    public static void adicionarTurmas(List<Turma> turmas) {
        for (Turma novaTurma : turmas) {
            if (turmaEhCadastrada(novaTurma)) {
                throw new IllegalArgumentException("Turma já cadastrada.");
            }
        }
        turmasCadastradas.addAll(turmas);
    }

    private static boolean turmaEhCadastrada(Turma turma) {
        return turmasCadastradas.contains(turma);
    }

    public static void excluirAluno(Aluno aluno) {
        for (Turma turma : turmasCadastradas) {
            boolean ehAlunoTurma = turma.getAlunos().contains(aluno);
            if (ehAlunoTurma) {
                turma.getAlunos().remove(aluno);
            }
        }
    }

    public static void listarTurmasCadastradas() {
        System.out.println("TURMAS CADASTRADAS");
        for (Turma turma : turmasCadastradas) {
            System.out.println(
                    "Id: " + turma.getID() + " - " +
                    "Curso: " + turma.getCurso().getNome() +
                    ", início da turma: " + turma.getAnoInicio() +
                    ", número de alunos: " + turma.getAlunos().size()
            );
        }
    }
}
