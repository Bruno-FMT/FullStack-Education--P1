package objetos;

public class Aluno {
    private static int proximoId;
    private String nome;
    private int idade;
    private int id;
    private StatusMatricula statusMatricula;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.statusMatricula = StatusMatricula.ATIVO;
        this.id = proximoId;
        proximoId++;
    }

    public void listarCurso() {

    }
    public void adicionarCurso() {

    }
    public void removerCurso() {

    }

    public int getId() {
        return id;
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

    public static void imprimirOpcoesStatusMatricula() {
        StatusMatricula[] opcoesStatus = StatusMatricula.values();
        for (int i = 0; i < opcoesStatus.length; i++) {
            System.out.println((i + 1) + "- " + opcoesStatus[i]);
        }
    }
}
