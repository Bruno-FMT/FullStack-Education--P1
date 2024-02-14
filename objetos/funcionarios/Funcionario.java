package objetos.funcionarios;

import objetos.StatusMatricula;

public class Funcionario {
    private String nome;
    private double salario;
    private CargoFuncionario cargo = CargoFuncionario.INICIANTE;

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

    public CargoFuncionario getCargo() {
        return cargo;
    }

    public boolean setCargo(String cargo) {
        try {
            this.cargo = CargoFuncionario.valueOf(cargo);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Cargo invalido.");
            return false;
        }
    }

    public void imprimirOpcoesCargoFuncionario() {
        CargoFuncionario[] cargoFuncionarios = CargoFuncionario.values();
        for (CargoFuncionario cargo : cargoFuncionarios) {
            System.out.println(cargo);
        }
    }
}
