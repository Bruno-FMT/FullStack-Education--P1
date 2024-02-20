package objetos.funcionarios;

import java.util.List;
import dados.DadosDiretores;

public class Diretor extends Funcionario {
    public Diretor(String nome, int idade, double salario, int anosCargo, String usuario, String senha) {
        super(nome, idade, salario, anosCargo, usuario, senha);
        DadosDiretores.adicionarDiretor(this);
    }
    public Diretor() {super();}

    public int getId() {
        List<Diretor> diretores = DadosDiretores.getDiretoresCadastrados();
        if(diretores.contains(this)) {
            return diretores.indexOf(this);
        }
        System.out.println("Diretor não encontrado.");
        return -1;
    }

    @Override
    public String toString() {
        return "{" +
                "nome: " + this.getNome() +
                ", nível: " + super.getNivelCargo() +
                '}';
    }
}
