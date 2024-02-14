package objetos;

import java.util.ArrayList;

public class Turma {
    private Curso curso;
    private ArrayList<Aluno> alunos;
    private int anoInicio;

    public void listarAlunos() {
        for(Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno);
        }
    }
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    public void removerAluno(Aluno objetoAluno) {
        alunos.remove(objetoAluno);
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
}
