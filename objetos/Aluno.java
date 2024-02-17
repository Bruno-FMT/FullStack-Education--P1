package objetos;

import dados.DadosAlunos;
import enums.StatusMatricula;

import java.util.List;

public class Aluno {
    private String nome;
    private int idade;

    private StatusMatricula statusMatricula;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.statusMatricula = StatusMatricula.ATIVO;
    }

    public void listarCurso() {

    }
    public void adicionarCurso() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 120)
            throw new IllegalArgumentException("Idade deve estar entre 0-120");
        this.idade = idade;
    }

    public StatusMatricula getStatusMatricula() {
        return statusMatricula;
    }

    public boolean setStatusMatricula(String statusMatricula) {
        try {
            this.statusMatricula = StatusMatricula.valueOf(statusMatricula);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Status de matrícula invalido.");
            return false;
        }
    }

    public int getId() {
        List<Aluno> alunos = DadosAlunos.getAlunosCadastrados();
        if(alunos.contains(this)) {
            return alunos.indexOf(this);
        }
        System.out.println("Aluno não encontrado.");
        return -1;
    }

    public static void imprimirOpcoesStatusMatricula() {
        StatusMatricula[] opcoesStatus = StatusMatricula.values();
        for (int i = 0; i < opcoesStatus.length; i++) {
            System.out.println((i + 1) + "- " + opcoesStatus[i]);
        }
    }

    @Override
    public String toString(){
        return String.format(
                "| %40s | %6d |",
                this.getNome(),
                this.getIdade()
        );
    }
}
