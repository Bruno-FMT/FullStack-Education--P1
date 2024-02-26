package dados;

import objetos.Curso;

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

    public static boolean getCursoPorNome(String nomeCurso) {
        for (Curso curso : cursosCadastrados) {
            if (curso.getNome().equals(nomeCurso)) {
                return true;
            } else {
                return false;
            }
        }
        throw new IllegalArgumentException("Nenhum curso encontrado com o nome informado.");
    }

    public static Curso getCursoPorId(int id) {
        if (id < 0 || id > cursosCadastrados.size()) {
            throw new IllegalArgumentException("Nenhum curso encontrado com o id informado.");
        }
        return cursosCadastrados.get(id);
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
        for (int i = 0; i < cursosCadastrados.size() ; i++) {
            System.out.println(
                    "ID: " + i + " - " +
                            ", Nome: " + cursosCadastrados.get(i).getNome() +
                            ", Número de professores: " + cursosCadastrados.get(i).getProfessores().size()
            );
        }
    }
}
