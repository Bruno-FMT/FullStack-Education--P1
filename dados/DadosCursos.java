package dados;

import objetos.Curso;

import java.util.ArrayList;

public class DadosCursos {
    private static ArrayList<Curso> cursosCadastrados = new ArrayList<>();

    public static void removerCurso(Curso curso) {
        if (!cursoEhCadastrado(curso)) {
            throw new IllegalArgumentException("Curso não encontrado.");
        }
        cursosCadastrados.remove(curso);
    }

    public static ArrayList<Curso> getCursosCadastrados() {
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
}
