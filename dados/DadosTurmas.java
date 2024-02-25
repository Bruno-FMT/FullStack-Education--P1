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
            if (turma.getAlunos() != null && turma.getAlunos().contains(aluno)) {
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

    public static void listarTurmasCadastradas() {
        for (int i = 0; i < turmasCadastradas.size() ; i++) {
            System.out.println(
                    "Id: " + i + " - " +
                    "Curso: " + turmasCadastradas.get(i).getCurso().getNome() +
                    ", início da turma: " + turmasCadastradas.get(i).getAnoInicio() +
                    ", número de alunos: " + turmasCadastradas.get(i).getAlunos().size()
            );
        }
    }
}
