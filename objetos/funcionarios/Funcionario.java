package objetos.funcionarios;

public class Funcionario {
    private String nome;
    private int idade;
    private double salario;
    private NiveisCargoFuncionario nivelCargo;
    private int anosCargo;

    public Funcionario(String nome, int idade, double salario, int anosCargo) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.anosCargo = anosCargo;
        this.nivelCargo = NiveisCargoFuncionario.INICIANTE;
    }

    public Funcionario() {}

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

    public NiveisCargoFuncionario getNivelCargo() {
        return nivelCargo;
    }

    public boolean setNivelCargo(String cargo) {
        try {
            this.nivelCargo = NiveisCargoFuncionario.valueOf(cargo);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Nível de cargo invalido.");
            return false;
        }
    }

    public void imprimirNiveisCargoFuncionario() {
        NiveisCargoFuncionario[] niveisCargo = NiveisCargoFuncionario.values();
        for (NiveisCargoFuncionario nivel : niveisCargo) {
            System.out.println(nivel);
        }
    }
}
