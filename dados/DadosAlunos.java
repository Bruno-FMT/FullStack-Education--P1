package dados;

import objetos.Aluno;
import objetos.StatusMatricula;

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
            DadosTurmas.excluirAluno(getAlunoPorId(id));
            alunosCadastrados.remove(id);
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Nenhum aluno encontrado com o id informado.");
        }
    }

    public static void removerAluno(Aluno aluno) {
        if (alunosCadastrados.contains(aluno)) {
            DadosTurmas.excluirAluno(aluno);
            alunosCadastrados.remove(aluno);
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Nenhum aluno encontrado com o id informado.");
        }
    }

    public static void listarTodosAlunosComId() {
        System.out.println("Todos os alunos cadastrados");
        for (Aluno aluno : alunosCadastrados) {
            System.out.println(
                    "Id: " + aluno.getId() +
                    " - Nome: " + aluno.getNome() +
                    ", Idade: " + aluno.getIdade() +
                    ", Status: " + aluno.getStatusMatricula()
            );
        }
    }

    public static void listarAlunosPorStatus(StatusMatricula status) {
        System.out.println("Lista de alunos " + status.toString());
        for (Aluno aluno : getAlunosPorStatus(status)) {
            System.out.println(
                    "Id: " + aluno.getId() +
                            " - Nome: " + aluno.getNome() +
                            ", Idade: " + aluno.getIdade() +
                            ", Status: " + aluno.getStatusMatricula()
            );
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

    public static ArrayList<Aluno> getAlunosPorStatus(StatusMatricula status) {
        ArrayList<Aluno> alunosFormados = new ArrayList<>();
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getStatusMatricula().equals(status)) {
                alunosFormados.add(aluno);
            }
        }
        return alunosFormados;
    }
}
