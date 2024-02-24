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
}
