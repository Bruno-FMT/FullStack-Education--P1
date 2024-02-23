package objetos;

import dados.DadosTurmas;

import java.util.ArrayList;

public class Turma {
    private Curso curso;
    private ArrayList<Aluno> alunos;
    private int anoInicio;

    public Turma() {
    }

    public Turma(Curso curso, ArrayList<Aluno> alunos, int anoInicio) {
        this.curso = curso;
        this.alunos = alunos;
        this.anoInicio = anoInicio;
        DadosTurmas.adicionarTurma(this);
    }

    public void listarAlunos() {
        for(Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno);
        }
    }
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }
    public void removerAluno(int posicao) {
        alunos.remove(posicao);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "curso=" + curso +
                ", alunos=" + alunos +
                ", anoInicio=" + anoInicio +
                '}';
    }
}
