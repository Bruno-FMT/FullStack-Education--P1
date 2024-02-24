package dados;

import objetos.Aluno;
import objetos.Curso;
import objetos.Turma;
import objetos.funcionarios.Professor;

import java.util.ArrayList;
import java.util.HashSet;
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

    public static List<Aluno> getAlunosPorProfessor(Professor professor) {
        List<Curso> cursos = DadosCursos.getCursosPorProfessor(professor);
        List<Turma> turmas = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();
        for (Curso curso : cursos) {
            turmas.addAll(DadosTurmas.getTurmasPorCurso(curso));
        }
        for (Turma turma : turmas) {
            alunos.addAll(turma.getAlunos());
        }
        HashSet<Aluno> listaSemDuplicatas = new HashSet<>(alunos);
        alunos.clear();
        alunos.addAll(listaSemDuplicatas);
        return alunos;
    }
}
