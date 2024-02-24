package dados;

import objetos.Curso;
import objetos.funcionarios.Professor;

import java.util.ArrayList;
import java.util.List;

public class DadosCursos {
    private static List<Curso> cursosCadastrados = new ArrayList<>();

    public static void removerCurso(Curso curso) {
        if (!cursoEhCadastrado(curso)) {
            throw new IllegalArgumentException("Curso não encontrado.");
        }
        cursosCadastrados.remove(curso);
    }

    public static List<Curso> getCursosCadastrados() {
        return cursosCadastrados;
    }

    public static List<Curso> getCursosPorProfessor(Professor professor) {
        List<Curso> cursos = new ArrayList<>();
        for (Curso curso : cursosCadastrados) {
            if(curso.getProfessores().contains(professor)) {
                cursos.add(curso);
            }
        }
        return cursos;
    }

    public static void adicionarCurso(Curso curso) {
        if (cursoEhCadastrado(curso)) {
            throw new IllegalArgumentException("Curso já cadastrado.");
        }
        cursosCadastrados.add(curso);
    }

    private static boolean cursoEhCadastrado(Curso curso) {
        return cursosCadastrados.contains(curso);
    }

    public static void excluirProfessor(Professor professor) {
        for (Curso curso : cursosCadastrados) {
            boolean ehProfessorCurso = curso.getProfessores().contains(professor);
            if (ehProfessorCurso) {
                curso.getProfessores().remove(professor);
            }
        }
    }
}
