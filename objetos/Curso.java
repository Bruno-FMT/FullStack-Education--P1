package objetos;

import java.util.ArrayList;

import dados.DadosCursos;
import objetos.funcionarios.Professor;

public class Curso {
    private String nome;
    private ArrayList<Professor> professores;

    public Curso(String nome, ArrayList<Professor> professores) {
        this.nome = nome;
        this.professores = professores;
        DadosCursos.adicionarCurso(this);
    }
    public void adicionarProfessor(Professor professor) {
        if (professores.contains(professor)) {
            throw new IllegalArgumentException("Professor já está neste curso.");
        }
        this.professores.add(professor);
    }

    public void removerProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            throw new IllegalArgumentException("Professor não está neste curso.");
        }
        this.professores.remove(professor);
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Professor> getProfessores() {
        return this.professores;
    }

    public int getId() {
        try {
            return DadosCursos.getCursosCadastrados().indexOf(this);
        } catch (Exception e) {
            throw new IllegalArgumentException("Curso não encontrado.");
        }
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", professores=" + professores +
                '}';
    }
}
