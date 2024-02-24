package objetos.funcionarios;

import dados.DadosProfessores;

import java.util.List;

public class Professor extends Funcionario {
    public Professor(String nome, int idade, double salario, int anosCargo, String usuario, String senha) {
        super(nome, idade, salario, anosCargo, usuario, senha);
        DadosProfessores.adicionarProfessor(this);
    }

    public Professor() {super();}

    public int getId() {
        List<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        if(professores.contains(this)) {
            return professores.indexOf(this);
        }
        System.out.println("Professor não encontrado.");
        return -1;
    }

    public static int getId(String usuario) {
        List<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        for (Professor professor : professores) {
            if (professor.getUsuario().equals(usuario)) {
                return professores.indexOf(professor);
            }
        }
        throw new IllegalArgumentException("Professor não encontrado.");
    }

    @Override
    public String toString() {
        return "{" +
                "nome: " + this.getNome() +
                ", nível: " + super.getNivelCargo() +
                '}';
    }
}
