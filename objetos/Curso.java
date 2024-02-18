package objetos;

import java.util.ArrayList;
import objetos.funcionarios.Professor;

public class Curso {
    private String nome;
    private ArrayList<Professor> professores;

    public Curso(String nome, ArrayList<Professor> professores) {
        setNome(nome);
        this.professores = professores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar em branco.");
        }
        this.nome = nome;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        for (Professor novoProfessor : professores) {
            if (professorEhCadastrado(novoProfessor)) {
                throw new IllegalArgumentException("Professor já cadastrado.");
            }
        }
        this.professores = professores;
    }
    public void setProfessor(Professor professor) {
        if(professorEhCadastrado(professor)) {
            throw new IllegalArgumentException("Professor já cadastrado.");
        }
        this.professores.add(professor);
    }

    private boolean professorEhCadastrado(Professor professor) {
        for (Professor professorCadastrado : professores) {
            if(professorCadastrado.getNome().equals(professor.getNome())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome: " + nome +
                ", professores: " + professores +
                "}";
    }
}
