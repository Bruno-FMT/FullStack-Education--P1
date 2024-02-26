package dados;

import objetos.Aluno;

import java.util.ArrayList;

public class DadosAlunos {
    private static ArrayList<Aluno> alunosCadastrados = new ArrayList<>();

    public static ArrayList<Aluno> getAlunosCadastrados() {
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
        DadosTurmas.excluirAluno(getAlunoPorId(id));
        alunosCadastrados.remove(id);
    }

    public static void removerAluno(Aluno aluno) {
        if (!alunosCadastrados.contains(aluno)) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }
        DadosTurmas.excluirAluno(aluno);
        alunosCadastrados.remove(aluno);
    }

    private static boolean alunoEhCadastrado(Aluno aluno) {
        for (Aluno alunoCadastrado : alunosCadastrados) {
            if(alunoCadastrado.getUsuario().equals(aluno.getUsuario())) {
                return true;
            }
        }
        return false;
    }

    public static void imprimirListaTodosAlunos() {
        System.out.println("ALUNOS CADASTRADOS");
        for (Aluno aluno : alunosCadastrados) {
            System.out.println("ID: " + aluno.getId() + ", Aluno:" + aluno.toString());
        }
    }

    public static Aluno getAlunoPorId(int id) {
        try {
            return alunosCadastrados.get(id);
        } catch (Exception e ) {
            throw new IllegalArgumentException("Nenhum aluno encontrado com o id informado.", e);
        }
    }

    public static Aluno getAlunoPorUsuario(String usuario) {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getUsuario().equals(usuario)) {
                return aluno;
            }
        }
        throw new IllegalArgumentException("Nenhum aluno encontrado com o usuário informado.");
    }
}