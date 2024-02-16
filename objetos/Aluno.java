package objetos;

public class Aluno {
    private static int proximoId;
    private String nome;
    private int idade;
    private int id;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.id = proximoId;
        proximoId++;
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
}
