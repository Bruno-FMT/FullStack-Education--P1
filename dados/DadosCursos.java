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

    public static void adicionarCurso(Curso curso) {
        if (cursoEhCadastrado(curso)) {
            throw new IllegalArgumentException("Curso já cadastrado.");
        }
        cursosCadastrados.add(curso);
    }

    private static boolean cursoEhCadastrado(Curso curso) {
        return cursosCadastrados.contains(curso);
    }

    public static void listarCursosCadastrados() {
        System.out.println("Cursos cadastrados");
        for (Curso curso : cursosCadastrados) {
            System.out.println(
                    "Id: " + curso.getId() +
                    "- Nome: " + curso.getNome() +
                    " Professores: " + curso.getProfessores().toString()
            );
        }
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
