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

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", professores=" + professores +
                '}';
    }
}
