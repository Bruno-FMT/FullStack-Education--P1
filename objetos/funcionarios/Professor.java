package objetos.funcionarios;

import dados.DadosCursos;
import dados.DadosProfessores;
import objetos.Aluno;
import objetos.Curso;
import objetos.Turma;

import java.util.ArrayList;
import java.util.HashSet;

public class Professor extends Funcionario {
    public Professor(String nome, int idade, double salario, int anosCargo, String usuario, String senha) {
        super(nome, idade, salario, anosCargo, usuario, senha);
        DadosProfessores.adicionarProfessor(this);
    }

    public Professor() {super();}

    public int getId() {
        ArrayList<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        if(professores.contains(this)) {
            return professores.indexOf(this);
        }
        System.out.println("Professor não encontrado.");
        return -1;
    }

    public static int getId(String usuario) {
        ArrayList<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        for (Professor professor : professores) {
            if (professor.getUsuario().equals(usuario)) {
                return professores.indexOf(professor);
            }
        }
        throw new IllegalArgumentException("Professor não encontrado.");
    }

    public ArrayList<Aluno> getAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Curso> cursos = getCursos();
        ArrayList<Turma> turmas = new ArrayList<>();
        for (Curso curso : cursos) {
            turmas.addAll(curso.getTurmas());
        }
        for (Turma turma : turmas) {
            alunos.addAll(turma.getAlunos());
        }
        HashSet<Aluno> listaSemDuplicatas = new HashSet<>(alunos);
        alunos.clear();
        alunos.addAll(listaSemDuplicatas);
        return alunos;
    }

    public ArrayList<Curso> getCursos() {
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Curso> cursosCadastrados = DadosCursos.getCursosCadastrados();
        for (Curso curso : cursosCadastrados) {
            if(curso.getProfessores().contains(this)) {
                cursos.add(curso);
            }
        }
        return cursos;
    }

    @Override
    public String toString() {
        return "{" +
                "nome: " + this.getNome() +
                ", nível: " + super.getNivelCargo() +
                '}';
    }

    public void listarTodosAlunos() {
        ArrayList<Aluno> alunos = getAlunos();
        System.out.println("Alunos do(a) professor(a): " + getNome());
        for (Aluno aluno : alunos) {
            System.out.println(
                    "ID: " + aluno.getId() +
                    ", Nome: " + aluno.getNome() +
                    ", Status:" + aluno.getStatusMatricula()
            );
        }
        if (alunos.isEmpty()) {
            System.out.println("Sem alunos cadastrados em seus cursos.");
        }
    }

    public void listarAlunoCursoTurma() {
        ArrayList<Curso> cursos = getCursos();
        System.out.println("Alunos do(a) professor(a): " + getNome());
        for (Curso curso : cursos) {
            System.out.println("Curso: " + curso.getNome());
            ArrayList<Turma> turmas = curso.getTurmas();
            for (int i = 0; i < turmas.size(); i++) {
                System.out.println("Turma: " + i + ", Início: " + turmas.get(i).getAnoInicio());
                ArrayList<Aluno> alunos = turmas.get(i).getAlunos();
                System.out.println("Alunos");
                for (Aluno aluno : alunos) {
                    System.out.println(
                            "ID: " + aluno.getId() +
                            ", Nome: " + aluno.getNome() +
                            ", Usuário: " + aluno.getUsuario() +
                            ", Status:" + aluno.getStatusMatricula()
                    );
                }
            }
            System.out.println();
        }
        if (cursos.isEmpty()) {
            System.out.println("Sem alunos cadastrados em seus cursos.");
        }
    }
}
