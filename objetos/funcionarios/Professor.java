package objetos.funcionarios;

import dados.DadosCursos;
import dados.DadosProfessores;
import dados.DadosTurmas;
import objetos.Aluno;
import objetos.Curso;
import objetos.Turma;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Professor extends Funcionario {
    public Professor(String nome, int idade, String usuario, String senha, double salario, int anosCargo) {
        super(nome, idade, usuario, senha, salario, anosCargo);
        DadosProfessores.adicionarProfessor(this);
    }
    public Professor() {
        super();
        DadosProfessores.adicionarProfessor(this);
    }

    public int getId() {
        List<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        if(professores.contains(this)) {
            return professores.indexOf(this);
        }
        System.out.println("Professor não encontrado.");
        return -1;
    }

    public ArrayList<Curso> getCursos() {
        List<Curso> cursosCadastrados = DadosCursos.getCursosCadastrados();
        ArrayList<Curso> cursos = new ArrayList<>();
        for (Curso curso : cursosCadastrados) {
            if (curso.getProfessores().contains(this)) {
                cursos.add(curso);
            }
        }
        return cursos;
    }

    public ArrayList<Turma> getTurmas() {
        List<Turma> turmasCadastradas = DadosTurmas.getTurmasCadastradas();
        ArrayList<Curso> cursos = getCursos();
        ArrayList<Turma> turmas = new ArrayList<>();
        for (Turma turma : turmasCadastradas) {
            for (Curso curso : cursos){
                if (turma.getCurso().equals(curso)) {
                    turmas.add(turma);
                }
            }
        }
        return turmas;
    }

    public ArrayList<Aluno> getTodosAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        List<Turma> turmas = getTurmas();
        for (Turma turma : turmas){
            alunos.addAll(turma.getAlunos());
        }
        HashSet<Aluno> alunosFormatado = new HashSet<>(alunos);
        alunos.clear();
        alunos.addAll(alunosFormatado);
        return alunos;
    }

    public void listarTodosAlunos() {
        ArrayList<Aluno> alunos = getTodosAlunos();
        System.out.println("Alunos");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(i + "- " + alunos.get(i).toString());
        }
    }

    public void listarAlunoPorCurso() {
        List<Turma> turmasCadastradas = getTurmas();
        for (Turma turma : turmasCadastradas) {
            System.out.println("Curso: " + turma.getCurso().getNome());
            ArrayList<Aluno> alunos = turma.getAlunos();
            System.out.println("Alunos");
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println(i + "- " + alunos.get(i).getNome());
            }
            System.out.println();
        }
    }
}
