package objetos.funcionarios;

import dados.DadosDiretores;

import java.util.List;

public class Diretor extends Funcionario {

    private double valorAdicionalCargo; //Valor adicional pela função de diretor (somar ao salário)

    public Diretor() {
    }
    public Diretor(String nome, int idade, double salario, int anosCargo) {
        super(nome, idade, salario, anosCargo);
    }

    public void setValorAdicionalCargo(double valorAdicionalCargo) {
        this.valorAdicionalCargo = valorAdicionalCargo;
    }
    public double getValorAdicionalCargo() {
        return valorAdicionalCargo;
    }
    @Override
    public double getSalario() {
        return this.valorAdicionalCargo + super.getSalario();
    }

    public int getId() {
        List<Diretor> diretores = DadosDiretores.getDiretoresCadastrados();
        if(diretores.contains(this)) {
            return diretores.indexOf(this);
        }
        System.out.println("Diretor não encontrado.");
        return -1;
    }
}
