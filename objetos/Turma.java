package objetos;

import dados.DadosTurmas;
import util.Datas;

import java.util.ArrayList;

public class Turma {
    private Curso curso;
    private ArrayList<Aluno> alunos;
    private int anoInicio;

    public Turma(Curso curso, int anoInicio, ArrayList<Aluno> alunos) {
        this.curso = curso;
        this.anoInicio = anoInicio;
        this.alunos = alunos;
        DadosTurmas.adicionarTurma(this);
    }

    public Turma(Curso curso, int anoInicio) {
        this.curso = curso;
        this.anoInicio = anoInicio;
        DadosTurmas.adicionarTurma(this);
    }

    public void imprimirListaAlunos() {
        if (alunos == null){
            System.out.println("Sem alunos cadastrados a turma.");
        } else {
            System.out.println("ALUNOS");
            for (Aluno aluno : alunos) {
                System.out.println(aluno.toString());
            }
        }
    }
    public void adicionarAluno(Aluno aluno) {
        if (alunoEhCadastrado(aluno)) {
            throw new IllegalArgumentException("Aluno já cadastrado.");
        }
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        if (!alunoEhCadastrado(aluno)) {
           throw new IllegalArgumentException("Aluno não está cadastrado nesta turma.");
        }
        alunos.remove(aluno);
    }
    public void removerAluno(int posicao) {
        if (posicao > alunos.size() || posicao < 0) {
            throw new IllegalArgumentException("Não há um aluno na posição informada.");
        }
        alunos.remove(posicao);
    }

    public String getNome() {
        return DadosTurmas.getTurmasCadastradas().indexOf(this) + "_" + this.getCurso().getNome();
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
        for (Aluno novoAluno : alunos) {
            if (alunoEhCadastrado(novoAluno)) {
                throw new IllegalArgumentException("Aluno já cadastrado.");
            }
        }
        this.alunos = alunos;
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        if (anoInicio < Datas.getAnoSistema()) {
            throw new IllegalArgumentException("Ano de início não pode ser menor que o ano atual.");
        }
        this.anoInicio = anoInicio;
    }

    private boolean alunoEhCadastrado(Aluno aluno) {
        return alunos.contains(aluno);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "anoInicio: " + anoInicio +
                ", curso: " + curso +
                ", alunos: " + alunos +
                '}';
    }
}
