package objetos.funcionarios;

import enums.NiveisCargoFuncionario;
import interfaces.IFuncionario;

public class Funcionario implements IFuncionario {
    private String nome;
    private int idade;
    private double salario;
    private NiveisCargoFuncionario nivelCargo;
    private int anosCargo;

    public Funcionario(String nome, int idade, double salario, int anosCargo) {
        setNome(nome);
        setIdade(idade);
        setSalario(salario);
        setAnosCargo(anosCargo);
        this.nivelCargo = NiveisCargoFuncionario.INICIANTE;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 120) {
            throw new IllegalArgumentException("Idade deve estar entre 0-120");
        }
        this.idade = idade;
    }

    public int getAnosCargo() {
        return anosCargo;
    }

    public void setAnosCargo(int anosCargo) {
        if (anosCargo < 0) {
            throw new IllegalArgumentException("Anos de cargo não pode ser negativo.");
        }
        this.anosCargo = anosCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar em branco.");
        }
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que zero.");
        }
        this.salario = salario;
    }

    public void promover(Funcionario funcionario,String nivelCargo) {
        funcionario.setNivelCargo(nivelCargo);
    }

    public NiveisCargoFuncionario getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(String nivelCargo) {
        try {
            this.nivelCargo = NiveisCargoFuncionario.valueOf(nivelCargo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Nível de cargo invalido.", e);
        }
    }

    public static void imprimirNiveisCargo() {
        NiveisCargoFuncionario[] niveisCargo = NiveisCargoFuncionario.values();
        for (int i = 0; i < niveisCargo.length; i++) {
            System.out.println((i + 1) + "- " + niveisCargo[i]);
        }
    }

    @Override
    public String toString() {
        return "Funcionário{" +
                "nome: " + nome +
                ", idade: " + idade +
                ", nível: " + nivelCargo +
                ", anos no cargo: " + anosCargo +
                '}';
    }
}
