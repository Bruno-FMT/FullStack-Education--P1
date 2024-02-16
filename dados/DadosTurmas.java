package dados;

import objetos.Turma;

import java.util.ArrayList;
import java.util.List;

public class DadosTurmas {
    private static List<Turma> turmasCadastradas = new ArrayList<>();

    public void removerTurma(Turma turma) {
        turmasCadastradas.remove(turma);
    }

    public List<Turma> getTurmasCadastradas() {
        return turmasCadastradas;
    }

    public void setTurma(Turma turma) {
        turmasCadastradas.add(turma);
    }
}
