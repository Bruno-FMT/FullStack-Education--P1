package objetos.funcionarios;

import dados.DadosAlunos;
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
    public Professor(String nome, int idade, double salario, int anosCargo, String usuario, String senha) {
        super(nome, idade, salario, anosCargo, usuario, senha);
        DadosProfessores.adicionarProfessor(this);
    }

    public Professor() {super();}

    public int getId() {
        List<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        if(professores.contains(this)) {
            return professores.indexOf(this);
        }
        System.out.println("Professor não encontrado.");
        return -1;
    }

    public static int getId(String usuario) {
        List<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        for (Professor professor : professores) {
            if (professor.getUsuario().equals(usuario)) {
                return professores.indexOf(professor);
            }
        }
        throw new IllegalArgumentException("Professor não encontrado.");
    }

    @Override
    public String toString() {
        return "{" +
                "nome: " + this.getNome() +
                ", nível: " + super.getNivelCargo() +
                '}';
    }

    public void listarTodosAlunos() {
        List<Aluno> alunos = DadosAlunos.getAlunosPorProfessor(this);
        System.out.println("Alunos do(a) professor(a): " + getNome());
        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getId() + ", Aluno: " + aluno.toString());
        }
    }

    public void listarAlunoCursoTurma() {
        List<Curso> cursos = DadosCursos.getCursosPorProfessor(this);
        for (Curso curso : cursos) {
            System.out.println("Curso: " + curso.getNome());
            List<Turma> turmas = DadosTurmas.getTurmasPorCurso(curso);
            for (int i = 0; i < turmas.size(); i++) {
                System.out.println("Turma: " + i + ", Início: " + turmas.get(i).getAnoInicio());
                ArrayList<Aluno> alunos = turmas.get(i).getAlunos();
                System.out.println("Alunos");
                for (Aluno aluno : alunos) {
                    System.out.println("ID: " + aluno.getId() + ", Nome: " + aluno.getNome());
                }
            }
            System.out.println();
        }
    }
}
