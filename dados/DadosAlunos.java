package dados;

import objetos.Aluno;

import java.util.ArrayList;
import java.util.List;

public class DadosAlunos {
    private static List<Aluno> alunosCadastrados = new ArrayList<>();

    public static List<Aluno> getAlunosCadastrados() {
        return alunosCadastrados;
    }

    public static void adicionarAluno(Aluno aluno) {
        alunosCadastrados.add(aluno);
        System.out.println("Aluno adicionado com sucesso.");
    }

    public static void adicionarAlunos(List<Aluno> alunos) {
        alunosCadastrados.addAll(alunos);
    }

    public static void removerAlunoPorId(int id) {
        if (id >= 0 && id < alunosCadastrados.size()) {
            alunosCadastrados.remove(id);
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Nenhum aluno encontrado com o id informado.");
        }
    }

    public static Aluno getAlunoPorId(int id) {
        if (id >= 0 && id < alunosCadastrados.size()) {
            return alunosCadastrados.get(id);
        } else {
            System.out.println("Nenhum aluno encontrado com o id informado.");
            return null;
        }
    }
}
