package objetos.funcionarios;

import dados.DadosDiretores;

import java.util.List;

public class Diretor extends Funcionario {
    public Diretor(String nome, int idade, double salario, int anosCargo) {
        super(nome, idade, salario, anosCargo);
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
