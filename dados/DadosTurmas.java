package dados;

import objetos.Aluno;
import objetos.Turma;

import java.util.ArrayList;

public class DadosTurmas {
    private static ArrayList<Turma> turmasCadastradas = new ArrayList<>();

    public static ArrayList<Turma> getTurmasCadastradas() {
        return turmasCadastradas;
    }

    public static ArrayList<Turma> getTurmasPorAluno(Aluno aluno) {
        ArrayList<Turma> turmas = new ArrayList<>();
        for (Turma turma : turmasCadastradas) {
            if (turma.getAlunos().contains(aluno)) {
                turmas.add(turma);
            }
        }
        return turmas;
    }

    public static Turma getTurmaPorId(int id) {
        if (id < 0 || id > turmasCadastradas.size()) {
            throw new IllegalArgumentException("Nenhum diretor encontrado com o id informado.");
        }
        return turmasCadastradas.get(id);
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

    public static void adicionarTurmas(ArrayList<Turma> turmas) {
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
            System.out.println(turma.toString());
        }
    }
}
