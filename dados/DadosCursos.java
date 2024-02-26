package dados;

import objetos.Curso;
import objetos.Turma;
import objetos.funcionarios.Professor;

import java.util.ArrayList;
import java.util.List;

public class DadosCursos {
    private static ArrayList<Curso> cursosCadastrados = new ArrayList<>();

    public static ArrayList<Curso> getCursosCadastrados() {
        return cursosCadastrados;
    }

    public static void removerCurso(Curso curso) {
        if (!cursoEhCadastrado(curso)) {
            throw new IllegalArgumentException("Curso não encontrado.");
        }
        if (cursoTemTurma(curso)){
            throw new IllegalArgumentException("Não podemos remover um curso com turma em andamento.");
        }
        cursosCadastrados.remove(curso);
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

    private static boolean cursoTemTurma(Curso curso) {
        List<Turma> turmas = DadosTurmas.getTurmasCadastradas();
        for (Turma turma : turmas) {
            if(turma.getCurso().equals(curso)) {
                return true;
            }
        }
        return false;
    }

    public static void excluirProfessor(Professor professor) {
        for (Curso curso : cursosCadastrados) {
            boolean ehProfessorCurso = curso.getProfessores().contains(professor);
            if (ehProfessorCurso) {
                curso.getProfessores().remove(professor);
            }
        }
    }

    public static void listarCursosCadastrados() {
        System.out.println("CURSOS CADASTRADOS");
        for (Curso curso : cursosCadastrados){
            System.out.println(
                    "Id: " + curso.getId() +
                    ", nome: " + curso.getNome() +
                    ", professores: " + curso.getProfessores().toString()
            );
        }
    }
}
