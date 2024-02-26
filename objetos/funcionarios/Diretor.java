package objetos.funcionarios;

import dados.DadosDiretores;

import java.util.ArrayList;

public class Diretor extends Funcionario {
    public Diretor(String nome, int idade, double salario, int anosCargo, String usuario, String senha) {
        super(nome, idade, salario, anosCargo, usuario, senha);
        DadosDiretores.adicionarDiretor(this);
    }
    public Diretor() {super();}

    public int getId() {
        ArrayList<Diretor> diretores = DadosDiretores.getDiretoresCadastrados();
        if(diretores.contains(this)) {
            return diretores.indexOf(this);
        }
        System.out.println("Diretor não encontrado.");
        return -1;
    }

    public static int getId(String usuario) {
        ArrayList<Diretor> diretores = DadosDiretores.getDiretoresCadastrados();
        for (Diretor diretor : diretores) {
            if (diretor.getUsuario().equals(usuario)) {
                return diretores.indexOf(diretor);
            }
        }
        throw new IllegalArgumentException("Diretor não encontrado.");
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Idade: " + getIdade() + ", Usuário: " + getUsuario() + ", Salário: " + getSalario() + ", Anos de Cargo: " + getAnosCargo();
    }
}