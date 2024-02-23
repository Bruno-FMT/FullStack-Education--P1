package dados;

import objetos.Curso;

import java.util.ArrayList;
import java.util.List;

public class DadosCursos {
    private static List<Curso> cursosCadastrados = new ArrayList<>();

    public static void removerCurso(Curso curso) {
        cursosCadastrados.remove(curso);
    }

    public static List<Curso> getCursosCadastrados() {
        return cursosCadastrados;
    }

    public static void adicionarCurso(Curso curso) {
        cursosCadastrados.add(curso);
    }

    public static void adicionarCursos(List<Curso> cursos){
        cursosCadastrados.addAll(cursos);
    }
}
