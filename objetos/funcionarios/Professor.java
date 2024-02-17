package objetos.funcionarios;

import dados.DadosProfessores;

import java.util.List;

public class Professor extends Funcionario {
    public Professor(String nome, int idade, double salario, int anosCargo) {
        super(nome, idade, salario, anosCargo);
    }

    public int getId() {
        List<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        if(professores.contains(this)) {
            return professores.indexOf(this);
        }
        System.out.println("Professor não encontrado.");
        return -1;
    }
}
