package objetos.funcionarios;

public class Funcionario {
    private static int proximoId;
    private String nome;
    private int idade;
    private double salario;
    private int anosCargo;
    private int id;

    public Funcionario(String nome, int idade, double salario, int anosCargo) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.anosCargo = anosCargo;
        this.id = proximoId;
        proximoId++;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAnosCargo() {
        return anosCargo;
    }

    public void setAnosCargo(int anosCargo) {
        this.anosCargo = anosCargo;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
