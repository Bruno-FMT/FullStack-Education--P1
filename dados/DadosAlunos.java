package dados;

import enums.StatusMatricula;
import objetos.Aluno;

import java.util.ArrayList;
import java.util.List;

public class DadosAlunos {
    private static List<Aluno> alunosCadastrados = new ArrayList<>();

    public static List<Aluno> getAlunosCadastrados() {
        return alunosCadastrados;
    }

    public static void adicionarAluno(Aluno aluno) {
        if (alunoEhCadastrado(aluno)) {
            throw new IllegalArgumentException("Aluno já cadastrado.");
        }
        alunosCadastrados.add(aluno);
    }

    public static void removerAlunoPorId(int id) {
        if (id < 0 || id > alunosCadastrados.size()) {
            throw new IllegalArgumentException("Nenhum aluno encontrado com o id informado.");
        }
        alunosCadastrados.remove(id);
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
        if (id < 0 || id > alunosCadastrados.size()) {
            throw new IllegalArgumentException("Nenhum aluno encontrado com o id informado.");
        }
        return alunosCadastrados.get(id);
    }

    public static Aluno getAlunoPorUsuario(String usuario) {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getUsuario().equals(usuario)) {
                return aluno;
            }
        }
        throw new IllegalArgumentException("Nenhum aluno encontrado com o usuário informado.");
    }

    private static boolean alunoEhCadastrado(Aluno aluno) {
        for (Aluno alunoCadastrado : alunosCadastrados) {
            if(alunoCadastrado.getUsuario().equals(aluno.getUsuario())) {
                return true;
            }
        }
        return false;
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
