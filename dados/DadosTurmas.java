package dados;

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

    public static void listarCursosCadastrados() {
        for (int i = 0; i < turmasCadastradas.size() ; i++) {
            System.out.println(i + "- " + turmasCadastradas.get(i).getCurso().getNome());
        }
    }
}
