package dados;

import objetos.Aluno;

import java.util.ArrayList;
import java.util.List;

public class DadosAlunos {
    private static List<Aluno> alunosCadastrados = new ArrayList<>();

    public static List<Aluno> getAlunosCadastrados() {
        return alunosCadastrados;
    }

    public void adicionarAluno(Aluno aluno) {
        alunosCadastrados.add(aluno);
        System.out.println("Aluno adicionado com sucesso.");
    }

    public void adicionarAlunos(List<Aluno> alunos) {
        alunosCadastrados.addAll(alunos);
    }

    public void removerAlunoPorId(int id) {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getId() == id) {
                alunosCadastrados.remove(aluno);
                System.out.println("Aluno removido com sucesso.");
            }
        }
    }

    public Aluno getAlunoPorId(int id) {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        System.out.println("Nenhum aluno encontrado com o ID informado.");
        return null;
    }
}
