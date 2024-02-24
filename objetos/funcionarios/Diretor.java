package objetos.funcionarios;

import dados.DadosDiretores;

import java.util.List;

public class Diretor extends Funcionario {
    public Diretor(String nome, int idade, String usuario, String senha, double salario, int anosCargo) {
        super(nome, idade, usuario, senha, salario, anosCargo);
        DadosDiretores.adicionarDiretor(this);
    }
    public Diretor() {
        super();
        DadosDiretores.adicionarDiretor(this);
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
