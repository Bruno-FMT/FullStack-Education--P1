package objetos;

import java.util.ArrayList;

import dados.DadosCursos;
import objetos.funcionarios.Professor;

public class Curso {
    private String nome;
    private ArrayList<Professor> professores = new ArrayList<>();

    public Curso(String nome, ArrayList<Professor> professores) {
        setNome(nome);
        setProfessores(professores);
        DadosCursos.adicionarCurso(this);
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
        this.professores = professores;
    }

    public void adicionaProfessor(Professor professor) {
        if(professorEhCadastrado(professor)) {
            throw new IllegalArgumentException("Professor já cadastrado.");
        }
        this.professores.add(professor);
    }

    public void removerProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            throw new IllegalArgumentException("Professor não está neste curso.");
        }
        this.professores.remove(professor);
    }

    private boolean professorEhCadastrado(Professor professor) {
        for (Professor professorCadastrado : this.professores) {
            if(professorCadastrado.getUsuario().equals(professor.getUsuario())) {
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
