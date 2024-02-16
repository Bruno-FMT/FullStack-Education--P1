package dados;

import objetos.Curso;

import java.util.ArrayList;
import java.util.List;

public class DadosCursos {
    private static List<Curso> cursosCadastrados = new ArrayList<>();

    public void removerCurso(Curso curso) {
        cursosCadastrados.remove(curso);
    }

    public List<Curso> getCursosCadastrados() {
        return cursosCadastrados;
    }

    public void setCurso(Curso curso) {
        cursosCadastrados.add(curso);
    }
}
