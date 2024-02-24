package dados;

import objetos.Aluno;
import objetos.Turma;

import java.util.ArrayList;
import java.util.List;

public class DadosTurmas {
    private static List<Turma> turmasCadastradas = new ArrayList<>();

    public static void removerTurma(Turma turma) {
        turmasCadastradas.remove(turma);
    }

    public static List<Turma> getTurmasCadastradas() {
        return turmasCadastradas;
    }

    public static void adicionarTurma(Turma turma) {
        turmasCadastradas.add(turma);
    }

    public static void adicionarTurmas(List<Turma> turmas) {
        turmasCadastradas.addAll(turmas);
    }

    public static void listarTurmasCadastradas() {
        System.out.println("Turmas cadastradas");
        for (Turma turma : turmasCadastradas) {
            System.out.println(
                    "Id: " + turma.getId() +
                    "- Nome curso: " + turma.getCurso().getNome() +
                    " Início: " + turma.getAnoInicio()
            );
        }
    }

    public static void excluirAluno(Aluno aluno) {
        for (Turma turma : turmasCadastradas) {
            boolean ehAlunoTurma = turma.getAlunos().contains(aluno);
            if (ehAlunoTurma) {
                turma.getAlunos().remove(aluno);
            }
        }
    }
}
