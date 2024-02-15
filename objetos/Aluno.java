package objetos;

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
    public void removerCurso() {

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

    public void imprimirOpcoesStatusMatricula() {
        StatusMatricula[] opcoesStatus = StatusMatricula.values();
        for (StatusMatricula status : opcoesStatus) {
            System.out.println(status);
        }
    }
}
