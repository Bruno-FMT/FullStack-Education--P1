package objetos.funcionarios;

import dados.DadosDiretores;

import java.util.List;

public class Diretor extends Funcionario {

    private double valorAdicionalHE; //Valor adicional por hora extra realizada

    public Diretor() {
    }
    public Diretor(String nome, int idade, double salario, int anosCargo) {
        super(nome, idade, salario, anosCargo);
    }

    public void setValorAdicionalHE(double valorAdicionalHE) {
        this.valorAdicionalHE = valorAdicionalHE;
    }
    public double getValorAdicionalHE() {
        return valorAdicionalHE;
    }
    @Override
    public double getSalario() {
        return this.valorAdicionalHE + super.getSalario();
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
