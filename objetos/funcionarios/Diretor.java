package objetos.funcionarios;

import dados.DadosDiretores;

import java.util.List;

public class Diretor extends Funcionario {
    public Diretor(String nome, int idade, double salario, int anosCargo) {
        super(nome, idade, salario, anosCargo);
    }

    public static int getId(String nome) {
        List<Diretor> diretores = DadosDiretores.getDiretoresCadastrados();
        for (Diretor diretor : diretores){
            if (diretor.getNome().equals(nome)) {
                return diretores.indexOf(diretor);
            }
        }

        System.out.println("Diretor não encontrado.");
        return -1;
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
